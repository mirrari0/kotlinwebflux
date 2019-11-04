package com.accenture.employee

import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono


@Repository
class EmployeeRepository {

    val employeeData = loadEmployeeData()
    val employeeAccessData = loadAccessData()

    private fun loadEmployeeData() : MutableMap<String, Employee>{
        val employeeData = mutableMapOf<String, Employee>()
        employeeData["1"] = Employee("1", "Employee 1")
        employeeData["2"] = Employee("2", "Employee 2")
        employeeData["3"] = Employee("3", "Employee 3")
        employeeData["4"] = Employee("4", "Employee 4")
        employeeData["5"] = Employee("5", "Employee 5")
        employeeData["6"] = Employee("6", "Employee 6")
        employeeData["7"] = Employee("7", "Employee 7")
        employeeData["8"] = Employee("8", "Employee 8")
        employeeData["9"] = Employee("9", "Employee 9")
        employeeData["10"] = Employee("10", "Employee 10")
        return employeeData
    }

    private fun loadAccessData() : MutableMap<String,String>{
        val employeeAccessData = mutableMapOf<String,String>()
        employeeAccessData["1"]="Employee 1 Access Key"
        employeeAccessData["2"]="Employee 2 Access Key"
        employeeAccessData["3"]="Employee 3 Access Key"
        employeeAccessData["4"]="Employee 4 Access Key"
        employeeAccessData["5"]="Employee 5 Access Key"
        employeeAccessData["6"]="Employee 6 Access Key"
        employeeAccessData["7"]="Employee 7 Access Key"
        employeeAccessData["8"]="Employee 8 Access Key"
        employeeAccessData["9"]="Employee 9 Access Key"
        employeeAccessData["10"]="Employee 10 Access Key"
        return employeeAccessData
    }


    fun findEmployeeById(id: String): Mono<Employee> {
        val employee = employeeData[id]
                        ?: Employee("Not Found", "Not Found")
        return Mono.just(employee)
    }

    fun findAllEmployees(): Flux<Employee> {
        return Flux.fromIterable(employeeData.values)
    }

    fun save(employee: Employee) : Mono<Employee>{
        employeeData[employee.id]=employee
        employeeAccessData[employee.id]=employee.generateAccessKey()
        return Mono.just(employee)
    }

}

private fun Employee.generateAccessKey(): String {
    return "Employee ${this.id} Access Key"
}
