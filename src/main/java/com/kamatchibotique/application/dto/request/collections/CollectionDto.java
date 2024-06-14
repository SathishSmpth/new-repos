package com.kamatchibotique.application.dto.request.collections;

import com.kamatchibotique.application.entity.product.ProductEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CollectionDto {
        private Long id;

        private String title;

        private boolean collectionStatus;

        @OneToMany
        private List<ProductEntity> products = new ArrayList<>();
}
