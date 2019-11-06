package com.example.employee

import org.springframework.web.reactive.function.client.WebClient

class EmployeeWebClient {
    private val client = WebClient.create("http://localhost:8080")

    fun consume() {

        val employeeMono = client.get()
            .uri("/employees/{id}", "1")
            .retrieve()
            .bodyToMono(Employee::class.java)

        employeeMono.subscribe()

        val employeeFlux = client.get()
            .uri("/employees")
            .retrieve()
            .bodyToFlux(Employee::class.java)

        employeeFlux.subscribe()
    }
}
