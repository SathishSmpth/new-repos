package com.kamatchibotique.application.service;

import com.kamatchibotique.application.dto.request.MerchantStoreDto;
import com.kamatchibotique.application.dto.response.MerchantStoreWithProductsDto;
import com.kamatchibotique.application.entity.MerchantStoreEntity;

import java.util.List;

public interface MerchantService {
    MerchantStoreWithProductsDto createMerchant(MerchantStoreDto merchantStoreDto);

    List<MerchantStoreWithProductsDto> getMerchantList();

    MerchantStoreWithProductsDto getMerchantById(Long id);

    MerchantStoreEntity findMerchantById(Long id);

    MerchantStoreWithProductsDto updateMerchant(long id, MerchantStoreDto merchantStoreDto);

    void deleteMerchant(long id);
}
