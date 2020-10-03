package com.danachury.samples.kotlincrudwebflux.services

import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface CrudService<T> {

    fun create(t: T): Mono<T>

    fun read(): Flux<T>

    fun <I> update(id: I, t: T): Mono<T>

    fun delete(id: Long): Mono<Boolean>
}
