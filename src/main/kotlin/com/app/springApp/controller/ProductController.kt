package com.app.springApp.controller

import com.app.springApp.model.Product
import com.app.springApp.service.ProductService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class ProductController(private val service: ProductService) {

  @GetMapping("/products")
  fun getProducts(): List<Product> {
    return service.getProducts()
  }

  @GetMapping("/products/{id}")
  fun getProductById(@PathVariable id: Int): Product {
    return service.getProductById(id)
  }
}
