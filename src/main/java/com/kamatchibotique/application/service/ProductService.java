package com.kamatchibotique.application.service;

import com.kamatchibotique.application.dto.request.product.ProductDto;

import java.util.List;

public interface ProductService {
    ProductDto createProduct(ProductDto product);
    List<ProductDto> getProductList();
    ProductDto getProductById(long id);
    ProductDto updateProduct(long  id, ProductDto product);
    void deleteProduct(long id);
    String generateProductUid(Long id);
}
