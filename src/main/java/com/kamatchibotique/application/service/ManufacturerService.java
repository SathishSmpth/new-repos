package com.kamatchibotique.application.service;

import com.kamatchibotique.application.dto.request.ManufacturerDto;
import com.kamatchibotique.application.dto.request.ManufacturerWithProductsDto;
import com.kamatchibotique.application.entity.ManufacturerEntity;

import java.util.List;

public interface ManufacturerService {
    List<ManufacturerWithProductsDto> getAllManufacturer();
    ManufacturerWithProductsDto getManufacturerById(Long id);
    ManufacturerEntity findManufacturerById(Long id);
    ManufacturerWithProductsDto createManufacturer(ManufacturerDto manufacturerDto);
    ManufacturerWithProductsDto updateManufacturer(Long id, ManufacturerDto manufacturerDto);
    void deleteManufacturer(Long id);
}