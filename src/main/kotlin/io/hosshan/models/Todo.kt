package io.hosshan.models

import java.io.Serializable
import javax.persistence.*


/**
 * Entity class
 */
@Entity
@Table(name = "todos")
class Todo(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column
        val id: Long,
        @Column(length = 50, nullable = false)
        val title: String,
        @Column(nullable = true)
        val body: String?,
        @Column(name = "is_done")
        val isDone: Boolean = false
) : Serializable {

}
