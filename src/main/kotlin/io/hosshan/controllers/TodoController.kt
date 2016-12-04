package io.hosshan.controllers

import io.hosshan.models.ErrorResponse
import io.hosshan.models.Todo
import io.hosshan.models.TodoRepository
import javassist.NotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

/**
 * Rest Controller
 */
@RestController
@EnableAutoConfiguration
@RequestMapping("/api/v1/todos")
class TodoController {

    @Autowired
    lateinit var todoRepository: TodoRepository

    @RequestMapping(method = arrayOf(RequestMethod.GET))
    @ResponseBody
    fun index(): List<Todo> =
            todoRepository.findAll().toList()

    @RequestMapping(value = "{id}", method = arrayOf(RequestMethod.GET))
    @ResponseBody
    fun details(@PathVariable("id") id: Long): Todo =
            todoRepository.findOne(id) ?: kotlin.run {
                throw NotFoundException("Todo(${id}) not found.")
            }

    @RequestMapping(method = arrayOf(RequestMethod.POST))
    @ResponseBody
    fun addTodo(@RequestBody params: Todo): Todo {
        params.checkValid()
        return todoRepository.save(Todo(
                id = 0,
                title = params.title,
                body = params.body,
                isDone = params.isDone
        ))
    }

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleException(exception: IllegalArgumentException): ResponseEntity<ErrorResponse> =
            ResponseEntity<ErrorResponse>(
                    ErrorResponse(exception.message ?: ""),
                    HttpStatus.BAD_REQUEST
            )

    @ExceptionHandler(NotFoundException::class)
    fun handleException(exception: NotFoundException): ResponseEntity<ErrorResponse> =
            ResponseEntity<ErrorResponse>(
                    ErrorResponse(exception.message ?: ""),
                    HttpStatus.NOT_FOUND
            )


    // Validation function
    fun Todo.checkValid() {
        if (title.isBlank()) {
            throw IllegalArgumentException("Title is not be blank.")
        }
    }

}