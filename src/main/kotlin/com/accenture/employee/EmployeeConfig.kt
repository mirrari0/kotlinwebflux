package com.accenture.employee

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.config.EnableWebFlux
import org.springframework.web.reactive.socket.WebSocketHandler
import org.springframework.web.reactive.socket.server.support.WebSocketHandlerAdapter
import org.springframework.web.servlet.HandlerMapping
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping

@Configuration
@EnableWebFlux
class EmployeeConfig {

    @Bean
    fun handlerMapping(): HandlerMapping {
        val map = mutableMapOf<String, WebSocketHandler>()
        map["/employee-feed"] = EmployeeWebSocketHandler()

        val mapping = SimpleUrlHandlerMapping()
        mapping.urlMap = map
        mapping.order = 10
        return mapping
    }

    @Bean
    fun handlerAdapter(): WebSocketHandlerAdapter {
        return WebSocketHandlerAdapter()
    }
}