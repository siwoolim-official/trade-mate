package com.trademate.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

@Configuration
@EnableJpaAuditing  // 감시 기능 설정
public class JpaAuditingConfig {

    // 생성자 자동 반환
    @Bean
    public AuditorAware<Long> auditorProvider() {
        return () -> Optional.of(1L); // 로그인 기능 개발전 까지 임시값 입력
    }


}
