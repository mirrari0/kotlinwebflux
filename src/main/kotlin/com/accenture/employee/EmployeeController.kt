package com.accenture.employee

import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/employees")
class EmployeeController(private val employeeRepository: EmployeeRepository) {

    @GetMapping("/{id}")
    fun getEmployeeById(@PathVariable id:String) : Mono<Employee> {
        return employeeRepository.findEmployeeById(id)
    }

    @GetMapping
    fun getAllEmployees() : Flux<Employee> {
        return employeeRepository.findAllEmployees()
    }

    @PostMapping("/{id}/{name}")
    fun addEmployee(@PathVariable id: String, @PathVariable name: String): Mono<Employee> {
        return employeeRepository.save(Employee(id, name))
    }
}