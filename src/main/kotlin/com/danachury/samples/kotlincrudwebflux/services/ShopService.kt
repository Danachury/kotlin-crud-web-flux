package com.danachury.samples.kotlincrudwebflux.services

import com.danachury.samples.kotlincrudwebflux.repository.ShopRepository
import com.danachury.samples.kotlincrudwebflux.web.data.Shop
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toMono

@Service
class ShopService(val shopRepository: ShopRepository) : CrudService<Shop> {

    override fun create(t: Shop): Mono<Shop> =
        this.shopRepository
            .create(t)
            .toMono()

    override fun read(): Flux<Shop> =
        this.shopRepository
            .read()
            .toMono()
            .flatMapMany { Flux.fromStream(it.stream()) }

    override fun <I> update(id: I, t: Shop): Mono<Shop> =
        this.shopRepository
            .update(id as Long /* WARN: Should throw cast Exception */, t)
            .toMono()

    override fun <I> delete(id: I): Mono<Boolean> =
        this.shopRepository
            .delete(id as Long /* WARN: Should throw cast Exception */)
            .toMono()
}
