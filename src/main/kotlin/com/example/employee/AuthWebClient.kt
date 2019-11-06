package com.example.employee

import org.springframework.web.reactive.function.client.WebClient

class AuthWebClient {
    private val client = WebClient.create("http://localhost:8080")

    fun consume() {
        val authMono = client.get()
            .uri("/auth/{password}", "1")
            .retrieve()
            .bodyToMono(String::class.java)

        authMono.subscribe()
    }
}