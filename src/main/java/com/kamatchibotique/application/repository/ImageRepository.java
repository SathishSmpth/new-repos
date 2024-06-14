package com.kamatchibotique.application.repository;

import com.kamatchibotique.application.entity.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ImageRepository extends JpaRepository<ImageEntity,Long> {
//    List<ImageEntity> findByDeletedFalse();
//    Optional<ImageEntity> findByIdAndDeletedFalse(Long id);

}
