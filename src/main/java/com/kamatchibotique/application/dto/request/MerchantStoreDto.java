package com.kamatchibotique.application.dto.request;

import com.kamatchibotique.application.dto.request.product.ProductVariantDto;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MerchantStoreDto {
    private Long id;
    private Boolean retailer;
    private String storeName;
    private String code;
    private String storePhone;
    private String address_line_one;
    private String address_line_two;
    private String storeCity;
    private String storeState;
    private String storePin;
    private String storeCountry;
    private String storeStateProvince;
    private String dateBusinessSince;
    private String defaultLanguage;
    private List<String> languages;
    private String storeTemplate;
    private String invoiceTemplate;
    private String storeEmailAddress;
    private String storeLogo;
    private String currency;
    private boolean currencyFormatNational;
    private boolean deleted;
    private List<ProductDto> products;
    private Date dateCreated;
    private Date dateModified;
    private String createdBy;
    private String modifiedBy;

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public class ProductDto {
        private Long id;
        private String title;
        private String description;
        private double price;
        private String sku;
        private String thumbnail;
        private BigDecimal length;
        private BigDecimal width;
        private BigDecimal height;
        private BigDecimal weight;
        private Integer productQuantity;
        private Date productDateAvailable;
        private String region;
        private Boolean available;
        private Integer productQuantityOrderMin;
        private Integer productQuantityOrderMax;
        private String collection;
        private String seUrl;
        private String metaTagTitle;
        private String metaTagKeywords;
        private String metaTagDescription;
        private Set<ProductVariantDto> variants;
        private Date dateCreated;
        private Date dateModified;
        private String createdBy;
        private String modifiedBy;
    }
}
