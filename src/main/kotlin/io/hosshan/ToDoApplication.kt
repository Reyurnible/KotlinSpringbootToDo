package io.hosshan

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class ToDoApplication

fun main(args: Array<String>) {
    SpringApplication.run(ToDoApplication::class.java, *args)
}
