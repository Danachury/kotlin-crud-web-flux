package com.danachury.samples.kotlincrudwebflux.services

import reactor.core.publisher.Mono

interface CrudService<T> {

    fun create(t: T): Mono<T>

    fun read(): Mono<List<T>>

    fun update(t: T): Mono<T>

    fun delete(id: Long): Mono<Boolean>
}