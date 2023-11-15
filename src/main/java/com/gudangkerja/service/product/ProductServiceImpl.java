package com.gudangkerja.service.product;

import com.gudangkerja.model.product.ProductRequest;
import com.gudangkerja.model.product.ProductResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public void addProduct(ProductRequest product, String token) {

    }

    @Override
    public void updateProduct(ProductRequest product, String token) {

    }

    @Override
    public void deleteProduct(Long id, String token) {

    }

    @Override
    public ProductResponse getProduct(Long id) {
        return null;
    }

    @Override
    public List<ProductResponse> getProducts() {
        return null;
    }
}
