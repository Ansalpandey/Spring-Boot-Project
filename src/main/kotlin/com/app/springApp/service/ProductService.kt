package com.app.springApp.service

import com.app.springApp.model.Product
import org.springframework.stereotype.Service

@Service
class ProductService {
  private val products =
      mutableListOf(
          Product(1, "Iphone 11", 69000.68, ""),
          Product(2, "Iphone 12", 69000.68, ""),
          Product(3, "Iphone 13", 69000.68, ""),
          Product(4, "Iphone 14", 69000.68, ""),
          Product(5, "Iphone 15", 69000.68, ""),
          Product(6, "Iphone 16", 69000.68, ""),
      )

  fun getProducts(): List<Product> {
    return products
  }

  fun getProductById(prodId: Int): Product {
    return products.find { it.id == prodId }!!
  }
}
