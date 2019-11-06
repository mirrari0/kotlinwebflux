package com.example.employee

import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class AuthService(private val passwordEncoder: PasswordEncoder) {

    fun encodePassword(password: String): Mono<String> {
        return Mono.just(passwordEncoder.encode(password))
    }

}