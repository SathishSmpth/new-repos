package com.kamatchibotique.application.entity.auditable;

import org.hibernate.annotations.CreationTimestamp;

public class Auditable {
    @CreationTimestamp
    protected U createdBy;

    @CreatedDate
    protected LocalDateTime createdDate;

    @LastModifiedBy
    protected U lastModifiedBy;

    @LastModifiedDate
    protected LocalDateTime lastModifiedDate;
}
