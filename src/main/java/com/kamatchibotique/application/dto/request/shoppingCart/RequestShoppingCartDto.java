package com.kamatchibotique.application.dto.request.shoppingCart;

import com.kamatchibotique.application.dto.request.ShoppingCartItemDto;

public class RequestShoppingCartDto {
    private ShoppingCartItemDto lineItems;
    private Long orderId;
    private String ipAddress;
}
