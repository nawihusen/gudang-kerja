package com.gudangkerja.service.product;

import com.gudangkerja.entities.Product;
import com.gudangkerja.model.product.ProductRequest;
import com.gudangkerja.model.product.ProductResponse;

import java.util.List;

public interface ProductService {
    void addProduct(ProductRequest product, String token);

    void updateProduct(ProductRequest product, Long id,String token);

    void deleteProduct(Long id, String token);

    ProductResponse getProduct(Long id, String token);

    List<ProductResponse> getProducts(String name);
}
