package com.accenture.employee

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class Employee (val id: String ="INVALID", val name: String = "INVALID" )