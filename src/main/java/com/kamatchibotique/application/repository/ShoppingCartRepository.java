package com.kamatchibotique.application.repository;

import com.kamatchibotique.application.entity.ShoppingCartEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCartEntity,Long> {
    Optional<ShoppingCartEntity> findByCustomerId(Long id);
}
