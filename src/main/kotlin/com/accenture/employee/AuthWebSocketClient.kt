package com.accenture.employee

import org.springframework.web.reactive.socket.client.ReactorNettyWebSocketClient
import java.net.URI

class AuthWebSocketClient {

    fun main(args: Array<String>) {
        val client = ReactorNettyWebSocketClient()
        client.execute(URI.create("ws://localhost:8080/auth-feed")) {session ->
            session.receive()
                .map<String> {it.payloadAsText}
                .doOnNext { println(it)}
                .then()
        }
            .block()
    }
}