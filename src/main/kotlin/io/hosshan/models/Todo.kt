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
        var title: String,
        @Column(nullable = true)
        var body: String?,
        @Column(name = "is_done")
        var isDone: Boolean? = false
) : Serializable {
    constructor() : this(0, "", null)

    override fun toString(): String {
        return "Todo(id=$id, title='$title', body=$body, isDone=$isDone)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other?.javaClass != javaClass) return false

        other as Todo

        if (id != other.id) return false
        if (title != other.title) return false
        if (body != other.body) return false
        if (isDone != other.isDone) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + title.hashCode()
        result = 31 * result + (body?.hashCode() ?: 0)
        result = 31 * result + (isDone?.hashCode() ?: 0)
        return result
    }
}