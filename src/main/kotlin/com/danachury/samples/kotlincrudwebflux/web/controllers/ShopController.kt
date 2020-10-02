package com.danachury.samples.kotlincrudwebflux.web.controllers

import com.danachury.samples.kotlincrudwebflux.services.ShopService
import com.danachury.samples.kotlincrudwebflux.web.data.Shop
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono

const val path = "/shops"

@RestController
class ShopController(val shopService: ShopService) {

    @PostMapping(value = [path])
    fun create(@RequestBody shop: Shop): Mono<Shop> {
        return this.shopService.create(shop)
    }

    @GetMapping(value = [path])
    fun read(): Mono<List<Shop>> {
        return this.shopService.read()
    }

    @PutMapping(value = [path])
    fun update(@RequestBody shop: Shop): Mono<Shop> {
        return this.shopService.update(shop)
    }

    @DeleteMapping(value = ["$path/{id}"])
    fun delete(@PathVariable id: Long): Mono<Boolean> {
        return this.shopService.delete(id)
    }

}
