package com.kamatchibotique.application.dto.mapper.product;

import com.kamatchibotique.application.Utils.BarcodeGenerator;
import com.kamatchibotique.application.dto.mapper.manufacturer.ManufacturerMapper;
import com.kamatchibotique.application.dto.mapper.merchant.MerchantMapper;
import com.kamatchibotique.application.dto.request.product.ProductDto;
import com.kamatchibotique.application.dto.response.ProductDtoWithoutMerchantAndManufacturer;
import com.kamatchibotique.application.entity.product.ProductEntity;
import com.kamatchibotique.application.service.CollectionService;
import com.kamatchibotique.application.service.ManufacturerService;
import com.kamatchibotique.application.service.MerchantService;
import com.kamatchibotique.application.service.ProductService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class ProductMapper {

    @Autowired
    private final ModelMapper mapper;

    @Autowired
    private CollectionService collectionService;

    @Autowired
    private ManufacturerService manufacturerService;

    @Autowired
    private MerchantService merchantService;

    @Autowired
    private ProductService productService;

    @Autowired
    private final ProductVariantMapper productVariantMapper;


    public ProductEntity convertToEntity(ProductDto productDto) {

        ProductEntity productEntity = new ProductEntity();

        productEntity.setId(productDto.getId());
        productEntity.setTitle(productDto.getTitle());
        productEntity.setDescription(productDto.getDescription());
        productEntity.setPrice(productDto.getPrice());
        productEntity.setSku(productDto.getSku());
        productEntity.setThumbnail(productDto.getThumbnail());
        productEntity.setLength(productDto.getLength());
        productEntity.setWidth(productDto.getWidth());
        productEntity.setHeight(productDto.getHeight());
        productEntity.setWeight(productDto.getWeight());
        productEntity.setProductQuantity(productDto.getProductQuantity());
        productEntity.setProductDateAvailable(productDto.getProductDateAvailable());
        productEntity.setRegion(productDto.getRegion());
        productEntity.setAvailable(productDto.getAvailable());
        productEntity.setProductQuantityOrderMin(productDto.getProductQuantityOrderMin());
        productEntity.setProductQuantityOrderMax(productDto.getProductQuantityOrderMax());
        productEntity.setSeUrl(productDto.getSeUrl());
        productEntity.setMetaTagTitle(productDto.getMetaTagTitle());
        productEntity.setMetaTagKeywords(productDto.getMetaTagKeywords());
        productEntity.setMetaTagDescription(productDto.getMetaTagDescription());
        productEntity.setDateCreated(productDto.getDateCreated());
        productEntity.setDateModified(productDto.getDateModified());
        productEntity.setCreatedBy(productDto.getCreatedBy());
        productEntity.setModifiedBy(productDto.getModifiedBy());
        productEntity.setProductUid(productService.generateProductUid(productEntity.getId()));

        try {
            String barcodeFilePath = "barcodes/" + productEntity.getSku() + ".png";
            BarcodeGenerator.saveBarcodeImage(productEntity.getSku(), 200, 100, barcodeFilePath);
            productEntity.setBarcodeFilePath(barcodeFilePath);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (productDto.getVariants() != null) {
            productEntity.setVariants(productDto.getVariants().stream().map(productVariantMapper::convertToEntity).collect(Collectors.toSet()));
        }


        if (productDto.getVariants() != null) {
            productEntity.setVariants(productDto.getVariants().stream().map(productVariantMapper::convertToEntity).collect(Collectors.toSet()));
        }

        if (productDto.getCollection() != null && productDto.getCollection().getId() != null) {
            productEntity.setCollection(collectionService.getCollectionById(productDto.getCollection().getId()));
        }

        if (productDto.getManufacturer() != null && productDto.getManufacturer().getId() != null) {
            productEntity.setManufacturer(manufacturerService.findManufacturerById(productDto.getManufacturer().getId()));
        }

        if (productDto.getMerchantStore() != null && productDto.getMerchantStore().getId() != null) {
            productEntity.setMerchantStore(merchantService.findMerchantById(productDto.getMerchantStore().getId()));
        }

        return productEntity;
    }

    public ProductEntity convertUpdateRequestToEntity(ProductDto productDto,ProductEntity productEntity) {
        updateEntity(productEntity, productDto);
        return productEntity;
    }

    public void updateEntity(ProductEntity productEntity, ProductDto productDto) {
        productEntity.setTitle(productDto.getTitle());
        productEntity.setDescription(productDto.getDescription());
        productEntity.setPrice(productDto.getPrice());
        productEntity.setSku(productDto.getSku());
        productEntity.setThumbnail(productDto.getThumbnail());
        productEntity.setLength(productDto.getLength());
        productEntity.setWidth(productDto.getWidth());
        productEntity.setHeight(productDto.getHeight());
        productEntity.setWeight(productDto.getWeight());
        productEntity.setProductQuantity(productDto.getProductQuantity());
        productEntity.setProductDateAvailable(productDto.getProductDateAvailable());
        productEntity.setRegion(productDto.getRegion());
        productEntity.setAvailable(productDto.getAvailable());
        productEntity.setProductQuantityOrderMin(productDto.getProductQuantityOrderMin());
        productEntity.setProductQuantityOrderMax(productDto.getProductQuantityOrderMax());
        productEntity.setSeUrl(productDto.getSeUrl());
        productEntity.setMetaTagTitle(productDto.getMetaTagTitle());
        productEntity.setMetaTagKeywords(productDto.getMetaTagKeywords());
        productEntity.setMetaTagDescription(productDto.getMetaTagDescription());
        productEntity.setDateCreated(productDto.getDateCreated());
        productEntity.setDateModified(productDto.getDateModified());
        productEntity.setCreatedBy(productDto.getCreatedBy());
        productEntity.setModifiedBy(productDto.getModifiedBy());

        if (productDto.getVariants() != null) {
            productEntity.setVariants(productDto.getVariants().stream().map(productVariantMapper::convertToEntity).collect(Collectors.toSet()));
        }

        if (productDto.getCollection() != null && productDto.getCollection().getId() != null) {
            productEntity.setCollection(collectionService.getCollectionById(productDto.getCollection().getId()));
        }

        if (productDto.getManufacturer() != null && productDto.getManufacturer().getId() != null) {
            productEntity.setManufacturer(manufacturerService.findManufacturerById(productDto.getManufacturer().getId()));
        }

        if (productDto.getMerchantStore() != null && productDto.getMerchantStore().getId() != null) {
            productEntity.setMerchantStore(merchantService.findMerchantById(productDto.getMerchantStore().getId()));
        }

        // Generate and set product UID if not already set
        if (productEntity.getProductUid() == null) {
            productEntity.setProductUid(productService.generateProductUid(productEntity.getId()));
        }

        // Generate and save barcode if the SKU has changed
        try {
            if (!productDto.getSku().equals(productEntity.getSku())) {
                String barcodeFilePath = "barcodes/" + productEntity.getSku() + ".png";
                BarcodeGenerator.saveBarcodeImage(productEntity.getSku(), 200, 100, barcodeFilePath);
                productEntity.setBarcodeFilePath(barcodeFilePath);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ProductDto convertToDto(ProductEntity product) {

        ProductDto productDto = new ProductDto();

        productDto.setId(product.getId());
        productDto.setTitle(product.getTitle());
        productDto.setDescription(product.getDescription());
        productDto.setPrice(product.getPrice());
        productDto.setSku(product.getSku());
        productDto.setThumbnail(product.getThumbnail());
        productDto.setLength(product.getLength());
        productDto.setWidth(product.getWidth());
        productDto.setHeight(product.getHeight());
        productDto.setWeight(product.getWeight());
        productDto.setProductQuantity(product.getProductQuantity());
        productDto.setProductDateAvailable(product.getProductDateAvailable());
        productDto.setRegion(product.getRegion());
        productDto.setProductQuantityOrderMin(product.getProductQuantityOrderMin());
        productDto.setAvailable(product.getAvailable());
        productDto.setBarcodeFilePath(product.getBarcodeFilePath());
        productDto.setProductQuantityOrderMax(product.getProductQuantityOrderMax());
        productDto.setSeUrl(product.getSeUrl());
        productDto.setMetaTagTitle(product.getMetaTagTitle());
        productDto.setMetaTagKeywords(product.getMetaTagKeywords());
        productDto.setMetaTagDescription(product.getMetaTagDescription());

        if (product.getVariants() != null) {
            productDto.setVariants(product.getVariants().stream().map(productVariantMapper::convertToDto).collect(Collectors.toSet()));
        }

        productDto.setDateCreated(product.getDateCreated());
        productDto.setDateModified(product.getDateModified());
        productDto.setCreatedBy(product.getCreatedBy());
        productDto.setModifiedBy(product.getModifiedBy());


        if (product.getManufacturer() != null) {
            productDto.getManufacturer().setId(product.getManufacturer().getId());
            productDto.getManufacturer().setManufacturer_image(product.getManufacturer().getManufacturer_image());
            productDto.getManufacturer().setManufacturer_name(product.getManufacturer().getManufacturer_name());
            productDto.getManufacturer().setManufacturer_email(product.getManufacturer().getManufacturer_email());
            productDto.getManufacturer().setManufacturer_phone(product.getManufacturer().getManufacturer_phone());
            productDto.getManufacturer().setAddress_line_one(product.getManufacturer().getAddress_line_one());
            productDto.getManufacturer().setAddress_line_two(product.getManufacturer().getAddress_line_two());
            productDto.getManufacturer().setCity(product.getManufacturer().getCity());
            productDto.getManufacturer().setState(product.getManufacturer().getState());
            productDto.getManufacturer().setCountry(product.getManufacturer().getCountry());
            productDto.getManufacturer().setPin(product.getManufacturer().getPin());
//            productDto.getManufacturer().setOrders(product.getManufacturer().getOrders());
            productDto.getManufacturer().setDateCreated(product.getManufacturer().getDateCreated());
            productDto.getManufacturer().setDateModified(product.getManufacturer().getDateModified());
            productDto.getManufacturer().setCreatedBy(product.getManufacturer().getCreatedBy());
            productDto.getManufacturer().setModifiedBy(product.getManufacturer().getModifiedBy());
        }

        if (product.getMerchantStore() != null) {
            productDto.getMerchantStore().setId(product.getMerchantStore().getId());
            productDto.getMerchantStore().setRetailer(product.getMerchantStore().getRetailer());
            productDto.getMerchantStore().setStoreName(product.getMerchantStore().getStoreName());
//            productDto.getMerchantStore().setCode(product.getMerchantStore().getCode());
            productDto.getMerchantStore().setStorePhone(product.getMerchantStore().getStorePhone());
            productDto.getMerchantStore().setAddress_line_one(product.getMerchantStore().getAddress_line_one());
            productDto.getMerchantStore().setAddress_line_two(product.getMerchantStore().getAddress_line_two());
            productDto.getMerchantStore().setStoreCity(product.getMerchantStore().getStoreCity());
            productDto.getMerchantStore().setStoreState(product.getMerchantStore().getStoreState());
            productDto.getMerchantStore().setStorePin(product.getMerchantStore().getStorePin());
            productDto.getMerchantStore().setDateBusinessSince(product.getMerchantStore().getDateBusinessSince());
            productDto.getMerchantStore().setDefaultLanguage(product.getMerchantStore().getDefaultLanguage());
            productDto.getMerchantStore().setLanguages(product.getMerchantStore().getLanguages());
            productDto.getMerchantStore().setStoreTemplate(product.getMerchantStore().getStoreTemplate());
            productDto.getMerchantStore().setInvoiceTemplate(product.getMerchantStore().getInvoiceTemplate());
            productDto.getMerchantStore().setStoreEmailAddress(product.getMerchantStore().getStoreEmailAddress());
            productDto.getMerchantStore().setStoreLogo(product.getMerchantStore().getStoreLogo());
            productDto.getMerchantStore().setCurrency(product.getMerchantStore().getCurrency());
            productDto.getMerchantStore().setDateCreated(product.getMerchantStore().getDateCreated());
            productDto.getMerchantStore().setDateModified(product.getMerchantStore().getDateModified());
            productDto.getMerchantStore().setCreatedBy(product.getMerchantStore().getCreatedBy());
            productDto.getMerchantStore().setModifiedBy(product.getMerchantStore().getModifiedBy());
        }

        return productDto;
    }
}
