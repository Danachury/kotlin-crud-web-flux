package com.danachury.samples.kotlincrudwebflux.config

import com.github.jasync.sql.db.ConnectionPoolConfiguration
import com.github.jasync.sql.db.pool.ConnectionPool
import com.github.jasync.sql.db.postgresql.PostgreSQLConnection
import com.github.jasync.sql.db.postgresql.PostgreSQLConnectionBuilder.createConnectionPool
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class PostgreSQLConfig(@Value("\${postgresql.host}") private val host: String,
                       @Value("\${postgresql.port}") private val port: Int,
                       @Value("\${postgresql.database}") private val database: String,
                       @Value("\${postgresql.username}") private val user: String,
                       @Value("\${postgresql.password}") private val password: String,
                       @Value("\${postgresql.pool-size}") private val poolSize: Int) {

    @Bean
    fun connectionPool(): ConnectionPool<PostgreSQLConnection> =
        createConnectionPool(ConnectionPoolConfiguration(
            this.host,
            this.port,
            this.database,
            this.user,
            this.password,
            this.poolSize
        ))
}
