package ru.test.demo

import lombok.extern.slf4j.Slf4j
import java.sql.*
import java.util.*
import java.util.logging.Logger
import kotlin.collections.ArrayList
import kotlin.math.log

@Slf4j
class ConnectionDB {

    private var conn: Connection? = null
    private val userName = "postgres"
    private val password = "secret"
    private val driver = "org.postgresql.Driver"
    private var statement: Statement? = null

    fun query(sql: String): List<Person> {

        var employees: MutableList<Person> = ArrayList();

        try {

            println("Connection to DB...")

//            var props: Properties = Properties()
//            props.setProperty("url", "jdbc:postgresql://localhost:5432/test")
//            props.setProperty("user", userName)
//            props.setProperty("password", password)

            Class.forName(driver)

//            DriverManager.registerDriver(driver, props)

            var conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/test", userName, password)

            print("Creating statement...")

            var statement = conn.createStatement()

            val query = "INSERT INTO Persons(id, name) VALUES (1, 'Jaky')"


            statement.execute(query)

            val sql2 = "INSERT INTO Employees(id, age, first, last) VALUES (1, 23, 'Sander', 'Nice')"

            statement.executeUpdate(sql2)

            val result: ResultSet = statement.executeQuery(sql)

            while (result.next()) {
                var id: Int = result.getInt("id")
                var age: Int = result.getInt("age")
                var first: String = result.getString("first")
                var last: String = result.getString("last")

                employees.add(Person(id, age, first, last))

                println("ID: ${id}")
                println("AGE: ${age}")
                println("FIRST NAME: ${first}")
                println("LAST NAME: ${last}")
            }

            result.close()
            statement.close()
            conn.close()

        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            try{
                conn?.close()
            } catch (e: Exception) {
                println(e.message)
            }

        }
        return employees
    }

}