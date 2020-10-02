package com.danachury.samples.kotlincrudwebflux.services

import com.danachury.samples.kotlincrudwebflux.repository.ShopRepository
import com.danachury.samples.kotlincrudwebflux.web.data.Shop
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class ShopService(val shopRepository: ShopRepository) : CrudService<Shop> {

    override fun create(t: Shop): Mono<Shop> =
        Mono.fromFuture(this.shopRepository.create(t))

    override fun read(): Mono<List<Shop>> =
        Mono.fromFuture(this.shopRepository.read())

    override fun update(t: Shop): Mono<Shop> =
        Mono.fromFuture(this.shopRepository.update(t))

    override fun delete(id: Long): Mono<Boolean> =
        Mono.fromFuture(this.shopRepository.delete(id))

}
