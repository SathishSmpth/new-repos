package com.kamatchibotique.application.repository;

import com.kamatchibotique.application.entity.ShoppingCartItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ShoppingCartItemRepository extends JpaRepository<ShoppingCartItemEntity,Long> {
    Optional<List<ShoppingCartItemEntity>> findAllByIdIn(List<Long> ids);
}
