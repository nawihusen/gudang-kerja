package com.gudangkerja.controller;

import com.gudangkerja.model.Response;
import com.gudangkerja.model.product.ProductRequest;
import com.gudangkerja.model.product.ProductResponse;
import com.gudangkerja.service.product.ProductService;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.naming.Name;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
     private ProductService productService;

    @PostMapping(path = "/product", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Response<String> postProduct(@RequestBody ProductRequest request, @RequestHeader(name = "token") String token){
        productService.addProduct(request, token);
        return Response.<String>builder().data("Berhasil Menambahkan Barang").build();
    }

    @PatchMapping(path = "/product/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Response<String> patchProduct(@RequestBody ProductRequest request, @PathVariable Long id, @RequestHeader(name = "token") String token){
        productService.updateProduct(request, id, token);
        return Response.<String>builder().data("Berhasil Update data").build();
    }

    @DeleteMapping(path = "/product/{id}")
    public Response<String> deleteProduct(@PathVariable(name = "id") Long id, @RequestHeader(name = "token") String token){
        productService.deleteProduct(id, token);
        return Response.<String>builder().data("Berhasil Menghapus Barang").build();
    }

    @GetMapping(path = "/product", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<List<ProductResponse>> getProducts(
            @RequestParam(name = "name") String name
    ){
        var products = productService.getProducts(name);
        return Response.<List<ProductResponse>>builder().data(products).build();
    }

    @GetMapping(path = "/product/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<ProductResponse> getProduct(@PathVariable("id") Long id, @RequestHeader(name = "token") String token){
        var product = productService.getProduct(id, token);
        return Response.<ProductResponse>builder().data(product).build();
    }

}
