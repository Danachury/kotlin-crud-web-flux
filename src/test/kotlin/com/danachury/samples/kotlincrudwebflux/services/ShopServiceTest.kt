package com.danachury.samples.kotlincrudwebflux.services

import com.danachury.samples.kotlincrudwebflux.repository.ShopRepository
import com.danachury.samples.kotlincrudwebflux.web.data.Shop
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.Duration
import java.util.concurrent.CompletableFuture.completedFuture
import java.util.concurrent.TimeUnit

internal class ShopServiceTest {

    private val shopRepository = mock(ShopRepository::class.java)
    private val shopService = ShopService(shopRepository)

    @Test
    fun shouldCreate() {
        // Arrange
        val shop = Shop(1, "My Shop")
        val future = completedFuture(shop)
        `when`(shopRepository.create(shop)).thenReturn(future)

        // Act
        val mono: Mono<Shop> = shopService.create(shop)
        val expected = future.get(10, TimeUnit.MILLISECONDS)
        val actual = mono.block(Duration.ofMillis(10))

        // Assert
        assertEquals(expected, actual)
        verify(shopRepository, times(1)).create(shop)
    }

    @Test
    fun shouldRead() {
        // Arrange
        val shops = listOf(Shop(1, "My Shop"))
        val future = completedFuture(shops)
        `when`(shopRepository.read()).thenReturn(future)

        // Act
        val flux: Flux<Shop> = shopService.read()
        val expected = future.get(10, TimeUnit.MILLISECONDS)
        val actual = flux.collectList().block(Duration.ofMillis(10))

        // Assert
        assertEquals(expected, actual)
        verify(shopRepository, times(1)).read()
    }

    @Test
    fun shouldUpdate() {
        // Arrange
        val shop = Shop(1, "My Shop")
        val future = completedFuture(shop)
        `when`(shopRepository.update(1, shop)).thenReturn(future)

        // Act
        val mono: Mono<Shop> = shopService.update(1.toLong(), shop)
        val expected = future.get(10, TimeUnit.MILLISECONDS)
        val actual = mono.block(Duration.ofMillis(10))

        // Assert
        assertEquals(expected, actual)
        verify(shopRepository, times(1)).update(1, shop)
    }

    @Test
    fun shouldDelete() {
        // Arrange
        val future = completedFuture(true)
        `when`(shopRepository.delete(1)).thenReturn(future)

        // Act
        val mono: Mono<Boolean> = shopService.delete(1.toLong())
        val expected = future.get(10, TimeUnit.MILLISECONDS)
        val actual = mono.block(Duration.ofMillis(10))

        // Assert
        assertEquals(expected, actual)
        verify(shopRepository, times(1)).delete(1)
    }
}
