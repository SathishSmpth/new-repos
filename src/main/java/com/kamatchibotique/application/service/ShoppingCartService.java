package com.kamatchibotique.application.service;

import com.kamatchibotique.application.entity.ShoppingCartEntity;
import com.kamatchibotique.application.entity.ShoppingCartItemEntity;

public interface ShoppingCartService {
    ShoppingCartEntity saveOrUpdate(ShoppingCartItemEntity item);

    ShoppingCartEntity getShoppingCart(Long customerId);

    ShoppingCartItemEntity populateShoppingCartItem(ShoppingCartItemEntity item,ShoppingCartEntity shoppingCart);

    void removeShoppingCart(Long id);
}
