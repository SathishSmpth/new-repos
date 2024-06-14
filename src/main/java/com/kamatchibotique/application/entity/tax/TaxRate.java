package com.kamatchibotique.application.entity.tax;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TaxRate {

    @Id
    @Column(name = "TAX_RATE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "SGST_TAX_RATE", nullable = false, precision = 7, scale = 4)
    private BigDecimal sgstTaxRate;

    @Column(name = "CGST_TAX_RATE", nullable = false, precision = 7, scale = 4)
    private BigDecimal cgstTaxRate;

    @NotNull
    @Column(name = "TAX_RATE_NAME")
    private String taxRateName;

    @NotNull
    @Column(name = "TAX_CODE")
    private String code;

    @Column(name = "EFFECTIVE_FROM")
    private LocalDate effectiveFrom;

    @ManyToOne
    @JoinColumn(name = "TAX_CLASS_ID", nullable = false)
    private TaxClass taxClass;
}
