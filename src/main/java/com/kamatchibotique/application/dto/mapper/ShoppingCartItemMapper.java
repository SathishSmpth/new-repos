package com.kamatchibotique.application.dto.mapper;

import com.kamatchibotique.application.dto.request.ShoppingCartItemDto;
import com.kamatchibotique.application.entity.ShoppingCartItemEntity;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ShoppingCartItemMapper {

    private final ModelMapper mapper;

    public ShoppingCartItemEntity convertToEntity(ShoppingCartItemDto shoppingCartItemDto) {
        return mapper.map(shoppingCartItemDto, ShoppingCartItemEntity.class);
    }

    public ShoppingCartItemDto convertToDto(ShoppingCartItemEntity merchantStore){
        return mapper.map(merchantStore,ShoppingCartItemDto.class);
    }
}
