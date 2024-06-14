package com.kamatchibotique.application.dto.request;

import com.kamatchibotique.application.dto.request.product.ProductDto;
import com.kamatchibotique.application.dto.request.product.ProductVariantDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ManufacturerDto {
    private Long id;
    private String manufacturer_image;
    private String manufacturer_name;
    private String manufacturer_email;
    private String manufacturer_phone;
    private String address_line_one;
    private String address_line_two;
    private String city;
    private String state;
    private String country;
    private String pin;
    private List<String> orders;
    private List<ProductDto> products;
//    private boolean deleted;
    private Date dateCreated;
    private Date dateModified;
    private String createdBy;
    private String modifiedBy;

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public static class ProductDto {
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
