package com.seohamin.depot.global.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(final CorsRegistry registry) {
        registry.addMapping("/**") // 모든 API 경로에 대해
//                .allowedOrigins("http://localhost:5173") // React(Vite) 개발 서버 주소 허용
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // 허용할 HTTP 메서드
                .allowedHeaders("*") // 모든 헤더 허용
//                .allowCredentials(true) // 세션/쿠키 인증을 위해 필요
                .maxAge(3600); // Preflight 요청의 캐시 시간(초)
    }
}
