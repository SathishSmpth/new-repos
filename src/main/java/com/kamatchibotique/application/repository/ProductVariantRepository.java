package com.kamatchibotique.application.repository;

import com.kamatchibotique.application.entity.product.variant.ProductVariant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductVariantRepository extends JpaRepository<ProductVariant,Long> {
//    List<ProductVariant> findByProductIdAndDeletedFalse(Long productId);
    List<ProductVariant> findByProductId(Long productId);
//    Optional<ProductVariant> findByIdAndDeletedFalse(Long id);
//    List<ProductVariant> findByDeletedTrue();
}
