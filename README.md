# Depot - Backend

파일을 서버로 업로드하고 저장하는 API 서버.

**개발 기간:** 2026.05.25 ~

## 기능

- **파일 업로드** — `multipart/form-data`로 다중 파일 업로드
- **비밀번호 인증** — 업로드 요청마다 비밀번호 검증
- **대용량 업로드 지원** — 파일당 최대 50GB, 요청당 최대 50GB
- **CORS 허용** — 모든 오리진에서 API 호출 가능
- **API 문서화** — Swagger UI로 명세 확인

## 시작하기

```bash
./gradlew bootRun
```

빌드:

```bash
./gradlew build
```

기본 활성 프로파일은 `prod`입니다. 로컬 개발 시 `application.yaml`의 `spring.profiles.active`를 `dev`로 변경하세요.

| 프로파일 | 포트 | 저장 경로 |
|----------|------|-----------|
| dev | 8080 | `save.dir`(application-dev.yaml) |
| prod | 51919 | `save.dir`(application-prod.yaml) |

## 기술 스택

| 역할 | 라이브러리 |
|------|-----------|
| 프레임워크 | Spring Boot 4.0.6 (Java 25) |
| API 문서 | springdoc-openapi (Swagger UI) |

## API

업로드 엔드포인트: `POST /api/v1/files`

| 필드 | 설명 |
|------|------|
| `files` | 업로드할 파일 (multipart/form-data, 다중 첨부 가능) |
| `password` | 업로드 비밀번호 |

| 상태 코드 | 의미 |
|-----------|------|
| `204` | 업로드 성공 |
| `400` | 잘못된 요청 (파일 누락, 경로 오류, 동일 파일명 존재 등) |
| `401` | 비밀번호 불일치 |
| `500` | 서버 오류 (저장 실패, 저장공간 부족 등) |

Swagger UI: `/api/swagger`

## 관련 저장소

- [depot-frontend](https://github.com/ggm77/depot-frontend) — 업로드 웹 클라이언트