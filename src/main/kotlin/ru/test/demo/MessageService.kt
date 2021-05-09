package ru.test.demo

import org.springframework.stereotype.Service

@Service
class MessageService() {
    fun findMessages(): List<Person> {
        val query: String = "SELECT * FROM Employees"
        var connection : ConnectionDB = ConnectionDB()
        return connection.query(query)
    }

//    fun post(message: Message) {
        // TODO
//    }
}
