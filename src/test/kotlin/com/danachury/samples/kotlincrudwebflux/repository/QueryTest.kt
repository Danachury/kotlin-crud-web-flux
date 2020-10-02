package com.danachury.samples.kotlincrudwebflux.repository

import com.danachury.samples.kotlincrudwebflux.repository.Query.Companion.delete
import com.danachury.samples.kotlincrudwebflux.repository.Query.Companion.insert
import com.danachury.samples.kotlincrudwebflux.repository.Query.Companion.selectFrom
import com.danachury.samples.kotlincrudwebflux.repository.Query.Companion.selectWhere
import com.danachury.samples.kotlincrudwebflux.repository.Query.Companion.update
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

class QueryTest {

    @Test
    internal fun shouldInitializeQuery() {
        val obj = Query()
        assertNotNull(obj)
    }

    @Test
    internal fun shouldBuildSelectFromQuery() {
        val selectFrom = selectFrom("shops")
        assertEquals(selectFrom, "SELECT * FROM shops;")
    }

    @Test
    internal fun shouldBuildSelectWhereQuery() {
        val selectFrom = selectWhere("shops", "id", "name")
        assertEquals(selectFrom, "SELECT * FROM shops WHERE id = ? AND name = ?;")
    }

    @Test
    internal fun shouldBuildInsertOneQuery() {
        val insert = insert("shops", arrayOf("name"))
        assertEquals(insert, "INSERT INTO shops(name) VALUES (?);")
    }

    @Test
    internal fun shouldBuildUpdateOneQuery() {
        val update = update("shops", arrayOf("name"))
        assertEquals(update, "UPDATE shops SET name = ? WHERE id = ?;")
    }

    @Test
    internal fun shouldBuildUpdateOneWithAndQuery() {
        val update = update("shops", arrayOf("name"), arrayOf("id", "name"))
        assertEquals(update, "UPDATE shops SET name = ? WHERE id = ? AND name = ?;")
    }

    @Test
    internal fun shouldBuildDeleteQuery() {
        val update = delete("shops")
        assertEquals(update, "DELETE FROM shops WHERE id = ?;")
    }

}
