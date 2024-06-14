package com.kamatchibotique.application.service.impl;

import com.kamatchibotique.application.dto.request.MerchantStoreDto;
import com.kamatchibotique.application.dto.response.MerchantStoreWithProductsDto;
import com.kamatchibotique.application.entity.MerchantStoreEntity;
import com.kamatchibotique.application.exception.ServiceException;
import com.kamatchibotique.application.dto.mapper.merchant.MerchantMapper;
import com.kamatchibotique.application.repository.MerchantRepository;
import com.kamatchibotique.application.service.AuthService;
import com.kamatchibotique.application.service.MerchantService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MerchantServiceImpl implements MerchantService {

    private final MerchantRepository merchantRepository;
    private final AuthService authService;
    private final MerchantMapper mapper;

    @Override
    public MerchantStoreWithProductsDto createMerchant(MerchantStoreDto merchantDto) {
        MerchantStoreEntity merchantStore = mapper.convertToEntity(merchantDto);

        merchantStore.setCreatedBy(authService.getAuthenticatedUsername());

        return mapper.convertToDtoWithProducts(merchantRepository.save(merchantStore));
    }

    @Override
    public List<MerchantStoreWithProductsDto> getMerchantList() {
        List<MerchantStoreEntity> listOfMerchant = merchantRepository.findAll();
        return listOfMerchant.stream().map(mapper::convertToDtoWithProducts).collect(Collectors.toList());
    }

    @Override
    public MerchantStoreWithProductsDto getMerchantById(Long id) {
        MerchantStoreEntity merchantStore = merchantRepository.findById(id).orElseThrow(() -> new ServiceException(HttpStatus.NOT_FOUND, "Merchant was not found in given id"));
        return mapper.convertToDtoWithProducts(merchantStore);
    }

    @Override
    public MerchantStoreEntity findMerchantById(Long id) {
        return merchantRepository.findById(id).orElseThrow(() -> new ServiceException(HttpStatus.NOT_FOUND, "Merchant was not found in given id"));
    }

    @Override
    public MerchantStoreWithProductsDto updateMerchant(long id, MerchantStoreDto merchantStore) {
        MerchantStoreEntity toUpdate = merchantRepository.findById(id).orElseThrow(() -> new ServiceException(HttpStatus.NOT_FOUND, "Merchant was not found in given id"));

        MerchantStoreEntity updatedMerchant = mapper.convertToEntity(merchantStore);

        updatedMerchant.setModifiedBy(authService.getAuthenticatedUsername());

        return mapper.convertToDtoWithProducts(merchantRepository.save(updatedMerchant));
    }

    @Override
    public void deleteMerchant(long id) {
        MerchantStoreEntity merchantStore = merchantRepository.findById(id).orElseThrow(() -> new ServiceException(HttpStatus.NOT_FOUND, "Merchant was not found in given id"));

        merchantRepository.delete(merchantStore);
    }
}
