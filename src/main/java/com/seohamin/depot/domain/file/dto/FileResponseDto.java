package com.seohamin.depot.domain.file.dto;

import java.time.Instant;

public record FileResponseDto(
        String name,
        Long size,
        Instant createdAt
) { }
