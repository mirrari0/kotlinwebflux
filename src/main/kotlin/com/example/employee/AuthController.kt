package com.example.employee

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/auth")
class AuthController(private val authService: AuthService) {


    @GetMapping("/{password}")
    fun encodePassword(@PathVariable password:String): Mono<String> {
        return authService.encodePassword(password)
    }
}