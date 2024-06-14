package com.kamatchibotique.application.repository;

import com.kamatchibotique.application.entity.collection.CollectionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollectionRepository extends JpaRepository<CollectionEntity,Long> {
//    List<CollectionEntity> findByDeletedFalse();
//    Optional<CollectionEntity> findByIdAndDeletedFalse(Long id);
}
