package com.danachury.samples.kotlincrudwebflux.web.controllers

import com.danachury.samples.kotlincrudwebflux.services.ShopService
import com.danachury.samples.kotlincrudwebflux.web.data.Shop
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono

const val path = "/shops"

@RestController
class ShopController(val shopService: ShopService) {

    @PostMapping(value = [path])
    fun create(@RequestBody shop: Shop): Mono<Shop> =
        this.shopService.create(shop)

    @GetMapping(value = [path])
    fun read(): Mono<List<Shop>> =
        this.shopService.read()

    @PutMapping(value = ["$path/{id}"])
    fun update(@PathVariable id: Long, @RequestBody shop: Shop): Mono<Shop> =
        this.shopService.update(id, shop)

    @DeleteMapping(value = ["$path/{id}"], produces = [APPLICATION_JSON_VALUE])
    fun delete(@PathVariable id: Long): Mono<String> =
        this.shopService
            .delete(id)
            .map { "{\"deleted\": $it}" }
}
