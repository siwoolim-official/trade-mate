package com.trademate.api.common.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.OffsetDateTime;

@MappedSuperclass // 공통 탬플릿 생성.
@EntityListeners(AuditingEntityListener.class) // 감시기능
@Getter
public class BaseEntity extends BaseTimeEntity {

    // 데이터 생성자 자동 등록
    @CreatedBy
    @Column(name = "created_by", updatable = false)
    private Long createdBy;

    // 데이터 수정자 자동 등록
    @LastModifiedBy
    @Column(name = "update_by")
    private Long updateBy;
}
