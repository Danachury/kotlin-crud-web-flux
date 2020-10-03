package com.danachury.samples.kotlincrudwebflux.web.controllers

import com.danachury.samples.kotlincrudwebflux.services.ShopService
import com.danachury.samples.kotlincrudwebflux.web.data.Shop
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/shops")
class ShopController(val shopService: ShopService) {

    @PostMapping
    fun create(@RequestBody shop: Shop): Mono<Shop> =
        this.shopService
            .create(shop)

    @GetMapping
    fun read(): Flux<Shop> =
        this.shopService
            .read()

    @PutMapping(value = ["/{id}"])
    fun update(@PathVariable id: Long, @RequestBody shop: Shop): Mono<Shop> =
        this.shopService
            .update(id, shop)

    @DeleteMapping(value = ["/{id}"], produces = [APPLICATION_JSON_VALUE])
    fun delete(@PathVariable id: Long): Mono<String> =
        this.shopService
            .delete(id)
            .map { "{\"deleted\": $it}" }
}
