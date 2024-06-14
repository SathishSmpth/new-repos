package com.kamatchibotique.application.service;

import com.kamatchibotique.application.dto.request.product.ProductVariantDto;

import java.util.List;

public interface ProductVariantService {
    ProductVariantDto addVariantToProduct(Long id, ProductVariantDto productVariantDto);

    List<ProductVariantDto> getListOfVariantByProductId(Long id);

    ProductVariantDto getListOfVariantByProductIdAndVariantId(Long productId,Long productVariantId);

    ProductVariantDto updateProductVariant(Long productId,Long productVariantId,ProductVariantDto productVariant);
    void deleteProductVariant(Long productId,Long productVariantId);
}
