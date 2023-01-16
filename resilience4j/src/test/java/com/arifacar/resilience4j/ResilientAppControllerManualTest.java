package com.arifacar.resilience4j;

import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import com.github.tomakehurst.wiremock.junit5.WireMockExtension;
import org.junit.Assert;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.IntStream;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.http.HttpStatus.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ResilientAppControllerManualTest {

    @RegisterExtension
    static WireMockExtension EXTERNAL_SERVICE = WireMockExtension.newInstance()
        .options(WireMockConfiguration.wireMockConfig()
            .port(9090))
        .build();


    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    @Order(1)
    public void testCircuitBreaker() {
        System.out.println("::: START CB :::");
        EXTERNAL_SERVICE.stubFor(WireMock.get("/api/external")
            .willReturn(serverError()));

        IntStream.rangeClosed(1, 5)
            .forEach(i -> {
                ResponseEntity<String> response = restTemplate.getForEntity("/api/circuit-breaker", String.class);
                assertThat(response.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
                System.out.println(response.getStatusCode());
            });

        IntStream.rangeClosed(1, 5)
            .forEach(i -> {
                ResponseEntity<String> response = restTemplate.getForEntity("/api/circuit-breaker", String.class);
                assertThat(response.getStatusCode()).isEqualTo(HttpStatus.SERVICE_UNAVAILABLE);
                System.out.println(response.getStatusCode());
            });

        EXTERNAL_SERVICE.verify(5, getRequestedFor(urlEqualTo("/api/external")));
        System.out.println("::: END CB :::");
    }

    @Test
    @Order(2)
    public void testRetry() {
        System.out.println("::: START RETRY :::");
        EXTERNAL_SERVICE.stubFor(WireMock.get("/api/external")
            .willReturn(ok()));
        ResponseEntity<String> response1 = restTemplate.getForEntity("/api/retry", String.class);
        EXTERNAL_SERVICE.verify(1, getRequestedFor(urlEqualTo("/api/external")));

        EXTERNAL_SERVICE.resetRequests();

        EXTERNAL_SERVICE.stubFor(WireMock.get("/api/external")
            .willReturn(serverError()));
        ResponseEntity<String> response2 = restTemplate.getForEntity("/api/retry", String.class);
        Assert.assertEquals(response2.getBody(), "all retries have exhausted");
        EXTERNAL_SERVICE.verify(3, getRequestedFor(urlEqualTo("/api/external")));
        System.out.println("::: END RETRY :::");
    }

    @Test
    @Order(3)
    public void testBulkhead() {
        System.out.println("::: START BH :::");
        EXTERNAL_SERVICE.stubFor(WireMock.get("/api/external")
            .willReturn(ok()));
        Map<Integer, Integer> responseStatusCount = new ConcurrentHashMap<>();

        IntStream.rangeClosed(1, 5)
            .parallel()
            .forEach(i -> {
                ResponseEntity<String> response = restTemplate.getForEntity("/api/bulkhead", String.class);
                int statusCode = response.getStatusCodeValue();
                responseStatusCount.put(statusCode, responseStatusCount.getOrDefault(statusCode, 0) + 1);
            });

        assertEquals(2, responseStatusCount.keySet()
            .size());
        assertTrue(responseStatusCount.containsKey(BANDWIDTH_LIMIT_EXCEEDED.value()));
        assertTrue(responseStatusCount.containsKey(OK.value()));
        EXTERNAL_SERVICE.verify(3, getRequestedFor(urlEqualTo("/api/external")));
        System.out.println("::: END BH :::");
    }

    @Test
    @Order(4)
    public void testTimeLimiter() {
        System.out.println("::: START TL :::");
        EXTERNAL_SERVICE.stubFor(WireMock.get("/api/external")
            .willReturn(ok()));
        ResponseEntity<String> response = restTemplate.getForEntity("/api/time-limiter", String.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.REQUEST_TIMEOUT);
        EXTERNAL_SERVICE.verify(1, getRequestedFor(urlEqualTo("/api/external")));
        System.out.println("::: END TL :::");
    }

    @Test
    @Order(5)
    public void testRatelimiter() {
        System.out.println("::: START RL :::");
        EXTERNAL_SERVICE.stubFor(WireMock.get("/api/external")
            .willReturn(ok()));
        Map<Integer, Integer> responseStatusCount = new ConcurrentHashMap<>();

        IntStream.rangeClosed(1, 500)
            .parallel()
            .forEach(i -> {
                ResponseEntity<String> response = restTemplate.getForEntity("/api/rate-limiter", String.class);
                int statusCode = response.getStatusCodeValue();
                int value = responseStatusCount.getOrDefault(statusCode, 0) + 1;
                responseStatusCount.put(statusCode, value);
                System.out.println(i + " - ST: " + statusCode + " - C: " + value);
            });

        assertEquals(2, responseStatusCount.keySet()
            .size());
        assertTrue(responseStatusCount.containsKey(TOO_MANY_REQUESTS.value()));
        assertTrue(responseStatusCount.containsKey(OK.value()));
        EXTERNAL_SERVICE.verify(100, getRequestedFor(urlEqualTo("/api/external")));
        System.out.println("::: END RL :::");
    }
}