package com.gudangkerja.service.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gudangkerja.entities.Product;
import com.gudangkerja.model.product.ProductRequest;
import com.gudangkerja.model.product.ProductResponse;
import com.gudangkerja.repository.mysql.ProductRepository;
import com.gudangkerja.utils.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    @Transactional
    public void addProduct(ProductRequest request, String token) {
        var product = new Product();
        product.setName(request.getName());
        product.setDesc(request.getDesc());
        product.setImage(request.getImage());
        product.setPrice(request.getPrice());
        product.setStock(request.getStock());

        productRepository.save(product);
    }

    @Override
    @Transactional
    public void updateProduct(ProductRequest request, Long id, String token) {
        var product = productRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "barang tidak di temukan"));

        if (Objects.nonNull(request.getName())){
            product.setName(request.getName());
        }

        if (Objects.nonNull(request.getDesc())){
            product.setDesc(request.getDesc());
        }

        if (Objects.nonNull(request.getImage())){
            product.setImage(request.getImage());
        }

        if (Objects.nonNull(request.getStock())){
            product.setStock(request.getStock());
        }

        if (Objects.nonNull(request.getPrice())){
            product.setPrice(request.getPrice());
        }

        productRepository.save(product);
    }

    @Override
    @Transactional
    public void deleteProduct(Long id, String token) {
        var product = productRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "barang tidak di temukan"));

        productRepository.delete(product);
    }

    @Override
    public ProductResponse getProduct(Long id) {
        var product = productRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "barang tidak di temukan"));

        return toResponse(product);
    }

    @Override
    public List<ProductResponse> getProducts() {
        var products = productRepository.findAll();
        List<ProductResponse> responses = products.stream()
                .map(data -> toResponse(data))
                .collect(Collectors.toList());
        return responses;
    }

    private ProductResponse toResponse(Product product){
        var response = new ProductResponse();
        response.setId(product.getId());
        response.setName(product.getName());
        response.setDesc(product.getDesc());
        response.setImage(product.getImage());
        response.setPrice(product.getPrice());
        response.setStock(product.getStock());
        response.setCreatedAt(Helper.toStringInstant(product.getCreatedAt()));
        response.setUpdatedAt(Helper.toStringInstant(product.getUpdatedAt()));

        return response;
    }
}
