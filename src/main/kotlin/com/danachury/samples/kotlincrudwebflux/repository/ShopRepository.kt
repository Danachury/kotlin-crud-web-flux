package com.danachury.samples.kotlincrudwebflux.repository

import com.danachury.samples.kotlincrudwebflux.repository.Query.Companion.delete
import com.danachury.samples.kotlincrudwebflux.repository.Query.Companion.insert
import com.danachury.samples.kotlincrudwebflux.repository.Query.Companion.selectFrom
import com.danachury.samples.kotlincrudwebflux.repository.Query.Companion.update
import com.danachury.samples.kotlincrudwebflux.web.data.Shop
import com.github.jasync.sql.db.QueryResult
import com.github.jasync.sql.db.RowData
import com.github.jasync.sql.db.pool.ConnectionPool
import com.github.jasync.sql.db.postgresql.PostgreSQLConnection
import org.springframework.stereotype.Repository
import java.util.concurrent.CompletableFuture

@Repository
class ShopRepository(val pgPool: ConnectionPool<PostgreSQLConnection>) {

    fun create(shop: Shop): CompletableFuture<Shop> {
        val query = insert(table, arrayOf(columns[1]))
        return this.executeQuery(query, listOf(shop.name))
            .thenApply { shop }
    }

    fun read(): CompletableFuture<List<Shop>> {
        val query = selectFrom(table)
        return this.executeQuery(query)
            .thenApply(fromQueryResult)
    }

    fun update(shop: Shop): CompletableFuture<Shop> {
        val query = update(table, arrayOf(columns[1]))
        return this.executeQuery(query, listOf(shop.name, shop.id))
            .thenApply { shop }
    }

    fun delete(id: Long): CompletableFuture<Boolean> {
        val query = delete(table)
        return this.executeQuery(query, listOf(id))
            .thenApply(oneRow)
    }


    fun executeQuery(query: String, values: List<Any?> = emptyList()) =
        this.pgPool.sendPreparedStatement(query, values)

    companion object {
        const val table = "shops"
        val columns = arrayOf("id", "name")

        private val fromQueryResult: (QueryResult) -> List<Shop> = {
            it.rows.map(fromRow)
        }

        private val fromRow: (RowData) -> Shop = {
            Shop(it.getLong(columns[0])!!, it.getString(columns[1])!!)
        }

        private val oneRow: (QueryResult) -> Boolean = {
            it.rowsAffected == 1L
        }
    }
}
