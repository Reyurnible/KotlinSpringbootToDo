package io.hosshan.models

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository


/**
 * Repository for Todo
 */
@Repository
interface TodoRepository : CrudRepository<Todo, Long> {


}