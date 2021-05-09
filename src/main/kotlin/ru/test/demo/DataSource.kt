package ru.test.demo

import org.flywaydb.core.Flyway
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DataSource {

    @Override
    @Bean
    public fun flyway(): Flyway {
        return Flyway.configure().dataSource("jdbc:postgresql://localhost:5432/test", "postgres", "secret").load()
    }


}