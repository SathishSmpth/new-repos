package com.kamatchibotique.application.entity.product;

import com.kamatchibotique.application.constants.SchemaConstant;
import com.kamatchibotique.application.entity.collection.CollectionEntity;
import com.kamatchibotique.application.entity.ManufacturerEntity;
import com.kamatchibotique.application.entity.MerchantStoreEntity;
import com.kamatchibotique.application.entity.product.variant.ProductVariant;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "PRODUCTS")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUCT_ID")
    private Long id;

    @Column(name = "PRODUCT_TITLE", nullable = false)
    private String title;

    @Column(name = "PRODUCT_DESCRIPTION", nullable = false)
    private String description;

    @Column(name = "PRODUCT_PRICE")
    private double price;

    @Column(name = "SKU")
    private String sku;

    @Column(name = "BAR_CODE")
    private String barcodeFilePath;

    @Column(name = "THUMBNAIL")
    private String thumbnail;

    @Column(name = "LENGTH")
    private BigDecimal length;

    @Column(name = "WIDTH")
    private BigDecimal width;

    @Column(name = "HEIGHT")
    private BigDecimal height;

    @Column(name = "WEIGHT")
    private BigDecimal weight;

    @NotNull
    @Column(name = "QUANTITY")
    private Integer productQuantity = 0;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_AVAILABLE")
    private Date productDateAvailable;

    @Column(name = "REGION")
    private String region = SchemaConstant.ALL_REGIONS;

    @Column(name = "AVAILABLE")
    private Boolean available;

    @Column(name = "PRODUCT_UID")
    private String productUid;

    @Column(name = "PRODUCT_QUANTITY_ORDER_MIN")
    private Integer productQuantityOrderMin = 0;

    @Column(name = "PRODUCT_QUANTITY_ORDER_MAX")
    private Integer productQuantityOrderMax = 0;

    @Column(name = "SEF_URL")
    private String seUrl;

    @Column(name = "META_TITLE")
    private String metaTagTitle;

    @Column(name = "META_KEYWORDS")
    private String metaTagKeywords;

    @Column(name = "META_DESCRIPTION")
    private String metaTagDescription;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "product")
    private Set<ProductVariant> variants = new HashSet<ProductVariant>();

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "MANUFACTURER_ID", nullable = false)
    private ManufacturerEntity manufacturer;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "MERCHANT_ID", nullable = false)
    private MerchantStoreEntity merchantStore;

    @ManyToOne
    @JoinColumn(name = "COLLECTION_ID", foreignKey = @ForeignKey(name = "FK_COLLECTION_ID"))
    private CollectionEntity collection;

    @CreationTimestamp
    @Column(name = "DATE_CREATED")
    private Date dateCreated;

    @UpdateTimestamp
    @Column(name = "DATE_MODIFIED")
    private Date dateModified;

    @Column(name = "CREATED_BY", length = 60)
    private String createdBy;

    @Column(name = "MODIFIED_BY", length = 60)
    private String modifiedBy;

    public void setProductQuantity(int quantity) {
        this.productQuantity = quantity;
        this.available = (quantity > 0);
    }
}
