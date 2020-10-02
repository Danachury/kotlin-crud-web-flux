package com.danachury.samples.kotlincrudwebflux

import com.danachury.samples.kotlincrudwebflux.web.controllers.ShopController
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class KotlinCrudWebFluxAppTests(@Autowired val shopController: ShopController) {

    @Test
    fun contextLoads() {
        assertThat(shopController).isNotNull
    }

}
