package com.kamatchibotique.application.dto.request.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ProductVariantDto {
    private Long id;
    private String size;
    private String color;
    private int quantity;
    private String image;
    private Date dateAvailable;
    private boolean available;
//    private boolean deleted;
    private Date dateCreated;
    private Date dateModified;
    private String createdBy;
    private String modifiedBy;
}
