package com.trademate.api.domain.user.entity;

import com.trademate.api.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.OffsetDateTime;

@Entity
@Table(name = "users")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class) // 생성 수정 시간 자동 기록
@SQLDelete(sql = "UPDATE users SET is_active = false WHERE id = ?") // 삭제 SQL
@Where(clause = "is_active = true") // 조회 조건
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 증가
    private Long id;

    @Column(nullable = false, unique = true, length = 255)
    private String email;           // 소셜 로그인 사용자 이메일

    @Column(nullable = false, length = 255)
    private String nickname;        // 커뮤니티 닉네임

    @Column(nullable = false, length = 50)
    private String provider;        // 소셜 로그인 출처

    @Column(name="profile_img_url", length = 500)
    private String profileImgUrl;   // 사용자 프로필 이미지

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;    // 논리 삭제 여부

    @CreatedDate
    @Column(name = "created_at", updatable = false)
    private OffsetDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private OffsetDateTime updatedAt;

    @Builder
    public User(String email, String nickname, String provider, String profileImgUrl) {
        this.email = email;
        this.nickname = nickname;
        this.provider = provider;
        this.profileImgUrl = profileImgUrl;
        this.isActive = true;
    }
}
