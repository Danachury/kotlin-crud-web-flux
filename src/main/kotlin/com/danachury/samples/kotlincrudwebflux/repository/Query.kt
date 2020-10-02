package com.danachury.samples.kotlincrudwebflux.repository

import org.jetbrains.annotations.Contract

class Query {

    companion object {

        private const val SELECT = "SELECT * FROM"

        @Contract(pure = true)
        fun selectFrom(tableName: String) =
            "$SELECT $tableName"

        @Contract(pure = true)
        fun selectWhere(tableName: String, vararg columns: String) =
            "${selectFrom(tableName)} ${where(arrayOf(*columns))}"

        @Contract(pure = true)
        fun insert(tableName: String, columns: Array<String>): String {
            val cols = columns.joinToString(", ", "(", ")")
            val values = columns.joinToString(", ", "(", ")") { "?" }
            return "INSERT INTO $tableName$cols VALUES $values;"
        }

        @Contract(pure = true)
        fun update(tableName: String, columns: Array<String>, condition: Array<String> = arrayOf("id")): String {
            val setFn = columns.joinToString(", ") { "$it = ?" }
            return "UPDATE $tableName SET $setFn ${where(condition)}"
        }

        @Contract(pure = true)
        fun delete(tableName: String, condition: Array<String> = arrayOf("id")): String {
            return "DELETE FROM $tableName ${where(condition)}"
        }

        @Contract(pure = true)
        fun where(columns: Array<String>): String {
            val whereFields = columns.joinToString(" AND ") { "$it = ?" }
            return "WHERE $whereFields;"
        }
    }

}
