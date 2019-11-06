package com.accenture.employee

import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.stereotype.Component
import org.springframework.web.reactive.socket.WebSocketHandler
import org.springframework.web.reactive.socket.WebSocketSession
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.Duration
import java.time.Instant
import java.util.UUID.randomUUID

@Component("AuthWebSocketHandler")
class AuthWebSocketHandler: WebSocketHandler {

    val om = ObjectMapper()

    override fun handle(webSocketSession: WebSocketSession): Mono<Void> {
        val authCreationEvent = Flux.generate<String> {
            sink ->
                val event = AuthCreationEvent(randomUUID().toString(), Instant.now().toString())
                try {
                    sink.next(om.writeValueAsString(event))
                }
                catch (e: JsonProcessingException) {
                    sink.error(e)
                }
        }

        return webSocketSession.send(authCreationEvent
            .map(webSocketSession::textMessage)
            .delayElements(Duration.ofSeconds(1)))

    }

}