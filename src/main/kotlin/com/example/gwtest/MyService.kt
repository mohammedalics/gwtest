package com.example.gwtest

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import org.springframework.cloud.circuitbreaker.resilience4j.ReactiveResilience4JCircuitBreakerFactory
import org.springframework.stereotype.Service

@Service
class MyService(
    val reactiveCircuitBreakerFactory: ReactiveResilience4JCircuitBreakerFactory,
) {
    @CircuitBreaker(name = "printhello1")
    fun printHello1() {
        print("Hello1")
    }

    fun printHello2() {
        val cb = reactiveCircuitBreakerFactory.create("printhello2")
        cb.run {
            println("Hello2")
        }
    }
}