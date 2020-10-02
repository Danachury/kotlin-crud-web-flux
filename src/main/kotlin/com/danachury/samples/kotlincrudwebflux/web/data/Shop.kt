package com.danachury.samples.kotlincrudwebflux.web.data

import com.danachury.samples.kotlincrudwebflux.web.entities.Entity

data class Shop(override val id: Long,
                val name: String,
                val customers: List<Customer> = emptyList()) : Entity(id = id)

data class Customer(override val id: Long,
                    val name: String,
                    val city: City,
                    val orders: List<Order> = emptyList()) : Entity(id = id) {
    override fun toString() = "$name from ${city.name}"
}

data class Order(override val id: Long,
                 val products: List<Product> = emptyList(),
                 val isDelivered: Boolean) : Entity(id = id)

data class Product(override val id: Long,
                   val name: String,
                   val price: Double) : Entity(id = id) {
    override fun toString() = "'$name' for $price"
}

data class City(override val id: Long,
                val name: String) : Entity(id = id) {
    override fun toString() = name
}
