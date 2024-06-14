package com.kamatchibotique.application.service;

import com.kamatchibotique.application.entity.collection.CollectionEntity;

import java.util.List;

public interface CollectionService {
    List<CollectionEntity> getListOfCollections();
    CollectionEntity getCollectionById(Long id);
    CollectionEntity saveCollection(CollectionEntity category);
    CollectionEntity updateCollection(Long id, CollectionEntity category);
    void deleteCollection(Long id);
}
