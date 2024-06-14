package com.kamatchibotique.application.dto.response;

import com.kamatchibotique.application.dto.request.product.ProductVariantDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDtoWithoutMerchantAndManufacturer {
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
//    private boolean deleted;
    private Date dateCreated;
    private Date dateModified;
    private String createdBy;
    private String modifiedBy;
}
