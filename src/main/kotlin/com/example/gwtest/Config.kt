//package com.example.gwtest
//
//import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig
//import io.github.resilience4j.timelimiter.TimeLimiterConfig
//import org.springframework.cloud.circuitbreaker.resilience4j.ReactiveResilience4JCircuitBreakerFactory
//import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder
//import org.springframework.cloud.client.circuitbreaker.Customizer
//import org.springframework.context.annotation.Bean
//import org.springframework.context.annotation.Configuration
//import java.time.Duration
//
//@Configuration
//class Config {
//
//    @Bean
//    fun defaultCustomizer(): Customizer<ReactiveResilience4JCircuitBreakerFactory> {
//        return Customizer<ReactiveResilience4JCircuitBreakerFactory> { factory ->
//            factory.configureDefault { id ->
//                Resilience4JConfigBuilder(id)
//                    .circuitBreakerConfig(CircuitBreakerConfig.ofDefaults())
//                    .timeLimiterConfig(TimeLimiterConfig.custom().timeoutDuration(Duration.ofSeconds(4)).build()).build()
//            }
//        }
//    }
//
//    @Bean
//    fun myServiceCusomtizer(): Customizer<ReactiveResilience4JCircuitBreakerFactory> {
//        return Customizer { factory: ReactiveResilience4JCircuitBreakerFactory ->
//            factory.configure(
//                { builder: Resilience4JConfigBuilder ->
//                    builder
//                        .timeLimiterConfig(TimeLimiterConfig.custom().timeoutDuration(Duration.ofSeconds(2)).build())
//                        .circuitBreakerConfig(CircuitBreakerConfig.ofDefaults())
//                }, "my-service"
//            )
//        }
//    }
//
//}