package com.kamatchibotique.application.entity.tax;

import com.kamatchibotique.application.entity.MerchantStoreEntity;
import com.kamatchibotique.application.entity.product.ProductEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tax_class")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TaxClass {

    private static final long serialVersionUID = 1L;

    public final static String DEFAULT_TAX_CLASS = "DEFAULT";

    @Id
    @Column(name = "TAX_CLASS_ID", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "TAX_CLASS_CODE", nullable = false, length = 10)
    private String code;

    @NotNull
    @Column(name = "TAX_CLASS_TITLE", nullable = false, length = 32)
    private String title;


    @OneToMany(mappedBy = "taxClass", targetEntity = ProductEntity.class)
    private List<ProductEntity> products = new ArrayList<ProductEntity>();


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MERCHANT_ID", nullable = true)
    private MerchantStoreEntity merchantStore;

    @OneToMany(mappedBy = "taxClass", cascade = CascadeType.ALL)
    private List<TaxRate> taxRates = new ArrayList<TaxRate>();
}
