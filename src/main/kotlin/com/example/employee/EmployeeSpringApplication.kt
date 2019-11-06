package com.example.employee

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class EmployeeSpringApplication

fun main(args: Array<String>) {

    runApplication<EmployeeSpringApplication>(*args)

    val employeeWebClient = EmployeeWebClient()
    employeeWebClient.consume()

    val authWebClient = AuthWebClient()
    authWebClient.consume()

}