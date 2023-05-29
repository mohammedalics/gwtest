package com.example.gwtest

import org.springframework.cloud.gateway.filter.GatewayFilter
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory
import org.springframework.stereotype.Component

@Component
class MyFilter(
    val myService: MyService
) : AbstractGatewayFilterFactory<MyFilter.Config>(Config::class.java) {

    class Config {}

    override fun apply(config: Config): GatewayFilter {
        return GatewayFilter { exchange, chain ->
            myService.printHello1()
            myService.printHello2()
            chain.filter(exchange)
        }
    }

}

