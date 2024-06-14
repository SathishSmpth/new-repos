package com.kamatchibotique.application.repository;

import com.kamatchibotique.application.entity.product.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<ProductEntity,Long> {
//  List<ProductEntity> findByDeletedFalse();
//  Optional<ProductEntity> findByIdAndDeletedFalse(Long id);
//  List<ProductEntity> findByDeletedTrue();
}
