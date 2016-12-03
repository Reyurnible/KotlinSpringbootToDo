package io.hosshan.models

import org.springframework.data.repository.CrudRepository


/**
 * Repository for Todo
 */
interface TodoRepository : CrudRepository<Todo, Long> {



}