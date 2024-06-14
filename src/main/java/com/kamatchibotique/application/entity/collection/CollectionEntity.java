package com.kamatchibotique.application.entity.collection;


import com.kamatchibotique.application.entity.product.ProductEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "COLLECTIONS")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CollectionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COLLECTION_ID")
    private Long id;

    @Column(name = "COLLECTION_TITLE")
    private String title;

    @Column(name = "COLLECTION_STATUS")
    private boolean collectionStatus;

    @OneToMany
    private List<ProductEntity> products = new ArrayList<>();
}
