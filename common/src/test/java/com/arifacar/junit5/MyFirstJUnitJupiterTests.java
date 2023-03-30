package com.arifacar.junit5;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

class MyFirstJUnitJupiterTests {

    private final Calculator calculator = new Calculator();

    @BeforeAll
    static void setup() {
        System.out.println("@BeforeAll - Bütün testler çalışmadan önce çalış");
    }

    @BeforeEach
    void init() {
        System.out.println("@BeforeEach - Her bir test çalışmadan önce çalış");
    }

    @DisplayName("Tekli test çalıştırıldı")
    @Test
    void testSingleSuccessTest() {
        System.out.println("Success");
    }

    @Test
    @Disabled("Not implemented yet")
    void testShowSomething() {
    }

    @AfterEach
    void tearDown() {
        System.out.println("@AfterEach - Her bir test metodu çalıştıktan sonra çalıştı.");
    }

    @AfterAll
    static void done() {
        System.out.println("@AfterAll -Bütün testler tamamlandıktan sonra çalıştı");
    }

    @Test
    @RepeatedTest(4)
    @DisplayName("Tekrarlanan testler")
    void addition() {
        assertEquals(2, calculator.add(1, 1));
    }

    @ParameterizedTest
    @ValueSource(strings = { "arif", "aca", "able was I ere I saw elba" })
    void palindromes(String candidate) {
        assertTrue(StringUtils.isPalindrome(candidate));
    }

    @Test
    void lambdaExpressions() {
        List numbers = Arrays.asList(1, 2, 3);
        int sum = numbers.stream().mapToInt(value -> (int) value).sum();
        assertTrue(sum > 5, "Sum should be greater than 5");
    }

    @Test
    void groupAssertions() {
        int[] numbers = {0, 1, 2, 3, 4};
        assertAll("numbers",
                () -> assertEquals(numbers[0], 1),
                () -> assertEquals(numbers[3], 3),
                () -> assertEquals(numbers[4], 1)
        );
    }


    @Test
    void trueAssumption() {
        assumeTrue(5 > 1);
        assertEquals(5 + 2, 7);
    }

    @Test
    void falseAssumption() {
        assumeFalse(5 < 1);
        assertEquals(5 + 2, 7);
    }

    @Test
    void assumptionThat() {
        String someString = "Arif Acar";
        assumingThat(
                someString.equals("Arif Acar"),
                () -> assertEquals(3 + 2, 4)
        );
    }
}