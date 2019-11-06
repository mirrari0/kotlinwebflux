package com.example.employee

import org.springframework.web.reactive.socket.client.ReactorNettyWebSocketClient
import java.net.URI

class EmployeeWebSocketClient {

    fun main(args: Array<String>) {
        val client = ReactorNettyWebSocketClient()
        client.execute(URI.create("ws://localhost:8080/employee-feed")) { session ->
            session.receive()
                .map<String> { it.payloadAsText }
                .doOnNext { println(it) }
                .then()
        }
            .block() // to subscribe and return the value

    }
}