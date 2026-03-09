package com.trademate.api.common.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.OffsetDateTime;
@MappedSuperclass // 공통 탬플릿 생성.
@EntityListeners(AuditingEntityListener.class) // 감시기능
@Getter
public class BaseTimeEntity {

    // 작성시간 자동 등록 UTC 기준
    @CreatedDate
    @Column(name = "created_at", updatable = false)
    private OffsetDateTime createdAt;

    // 데이터 수정일 자동 갱신
    @LastModifiedDate
    @Column(name = "updated_at")
    private OffsetDateTime updatedAt;

    // 논리적 삭제 여부
    @Column(name ="is_active", nullable = false)
    private Boolean isActive = true;

    public void deleteSoftly() {
        this.isActive = false;
    }
}
