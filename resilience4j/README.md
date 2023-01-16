# Spring Boot Resilience4j Implementation

This module contains the implementation of Resilience4j.

### Libraries

- Spring Boot
- Resilience4j
- Wiremock
- Awaitility
- JUnit

# Circuit Breaker Pattern

# **Circuit Breaker**

`minimum-number-of-calls=5`

Sigortanın açık konuma geçmesini veya kapalı konumda kalmasını sağlayacak hatalı/yavaş çağrı oranlarının hesaplanması için yapılması gereken asgari çağrı sayısını belirtir.

`permitted-number-of-calls-in-half-open-state=3`

Sigorta yarı-açık konumda iken kritik bölgeye yapılabilecek çağrı sayısıdır.

`automatic-transition-from-open-to-half-open-enabled=true`

Sigortanın açık konumdan yarı-açık konuma el yordamı gerekmeksizin geçebilmesini sağlar (`true` ise). Bu özelliğin `false` değerine sahip olması durumunda sigorta, ancak el yordamıyla yarı-açık konuma geçirilebilir.

`wait-duration-in-open-state=5s`

Sigortanın açık konumdan yarı-açık konuma geçmesi için geçmesi beklenen süredir

# Retry

**@Retry(name =”`retryApi`”)** - N defa tekrar denemesini sağlar.

`resilience4j.retry.instances.**retryApi**.max-attempts=3`

3 defa denedikten sonra hard coded olarak döneceği mesaj.

`@Retry(name = "retryApi", fallbackMethod = "**fallbackAfterRetry**")`

```java
public String **fallbackAfterRetry**(Exception ex) {
        return "all retries have exhausted";
    }
```

`resilience4j.retry.instances.retryApi.wait-duration=1s`

1 sn aralıkla deneme yapsın. 3x1 = 3 sn ekstra deneme olacak.

`resilience4j.retry.instances.retryApi.exponential-backoff-multiplier=2`

önce 1 sn sonra 2 sonra da 4 sn aralıkla dener.

# Rate Limiter

Örneğin 10 sn içinde `rateLimiterApi` ’e saniyede 10bin isteğe izin veriyorum demek istediğimizde kullanırız.

`@RateLimiter(name = "rateLimiterApi")`

`resilience4j.ratelimiter.instances.rateLimiterApi.limit-for-period=100`

`resilience4j.ratelimiter.instances.rateLimiterApi.limit-refresh-period=60s`

Her 60 saniyede 100 isteğe izin ver gibi.

# ****BulkHead****

Aynı anda kaç tane isteğe yanıt verebileceğini bildiririz.

`resilience4j.bulkhead.instances.bulkheadApi.max-concurrent-calls=3`

`resilience4j.bulkhead.instances.bulkheadApi.max-wait-duration=1`

En fazla 3 eşzamanlı çağrıda bulunabilir.