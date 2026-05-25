package com.seohamin.depot.domain.file.controller;

import com.seohamin.depot.domain.file.dto.FileCheckRequestDto;
import com.seohamin.depot.domain.file.dto.FileCheckResponseDto;
import com.seohamin.depot.domain.file.dto.FileResponseDto;
import com.seohamin.depot.domain.file.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.Instant;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class FileController {

    private final FileService fileService;

    @PostMapping(value = "/files", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> uploadFiles(
            @RequestParam(value = "files", required = true) final List<MultipartFile> files,
            @RequestParam(value = "password", required = true) final String password
    ) {

        fileService.uploadFile(files, password);

        return ResponseEntity.noContent().build();
    }

    @PostMapping("/file/check")
    public ResponseEntity<FileCheckResponseDto> checkFile(
            @RequestBody final FileCheckRequestDto fileCheckRequestDto
    ) {

        // mock
        return ResponseEntity.ok(new FileCheckResponseDto(false));
    }
}
