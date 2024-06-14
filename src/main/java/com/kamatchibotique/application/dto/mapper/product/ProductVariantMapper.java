package com.kamatchibotique.application.dto.mapper.product;

import com.kamatchibotique.application.dto.request.product.ProductVariantDto;
import com.kamatchibotique.application.entity.product.variant.ProductVariant;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ProductVariantMapper {

    private final ModelMapper mapper;

    public ProductVariant convertToEntity(ProductVariantDto productVariantDto) {
        return mapper.map(productVariantDto, ProductVariant.class);
    }

    public ProductVariantDto convertToDto(ProductVariant productVariant) {
        return mapper.map(productVariant, ProductVariantDto.class);
    }
}
