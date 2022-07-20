/*
 * (C) Copyright Hemajoo Systems Inc.  2022 - All Rights Reserved
 * -----------------------------------------------------------------------------------------------
 * All information contained herein is, and remains the property of
 * Hemajoo Inc. and its suppliers, if any. The intellectual and technical
 * concepts contained herein are proprietary to Hemajoo Inc. and its
 * suppliers and may be covered by U.S. and Foreign Patents, patents
 * in process, and are protected by trade secret or copyright law.
 *
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained from
 * Hemajoo Systems Inc.
 * -----------------------------------------------------------------------------------------------
 */
package com.hemajoo.commerce.cherry.base.data.model.base.audit;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * Represent an abstract data model entity containing <b>audit</b> information.
 * @author <a href="mailto:christophe.resse@gmail.com">Christophe Resse</a>
 * @version 1.0.0
 */
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractAuditEntity implements IAuditEntity
{
    /**
     * DataModelEntity creation date.
     */
    @Schema(hidden = true)
    @Getter
    @Setter
    @Column(name = "CREATED_DATE", length = 26)
    @CreatedDate
    private Date createdDate;

    /**
     * DataModelEntity modification date.
     */
    @Schema(hidden = true)
    @Getter
    @Setter
    @Column(name = "MODIFIED_DATE", length = 26)
    @LastModifiedDate
    private Date modifiedDate;

    /**
     * DataModelEntity author.
     */
    @Schema(hidden = true)
    @Getter
    @Setter
    @Column(name = "CREATED_BY", length = 50)
    @CreatedBy
    private String createdBy;

    /**
     * DataModelEntity last modification author.
     */
    @Schema(hidden = true)
    @Getter
    @Setter
    @Column(name = "MODIFIED_BY", length = 50)
    @LastModifiedBy
    private String modifiedBy;
}
