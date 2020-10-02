package com.danachury.samples.kotlincrudwebflux.repository

import java.util.concurrent.CompletableFuture

interface JDBRepository<T> {

    fun <O> create(t: T): CompletableFuture<O>

    fun <O> read(t: T): CompletableFuture<O>

    fun <O> update(t: T): CompletableFuture<O>

    fun <O> delete(t: T): CompletableFuture<O>
}
