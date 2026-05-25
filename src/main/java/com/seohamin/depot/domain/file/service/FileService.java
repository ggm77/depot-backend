package com.seohamin.depot.domain.file.service;

import com.seohamin.depot.global.exception.CustomException;
import com.seohamin.depot.global.exception.constants.ExceptionCode;
import com.seohamin.depot.global.infra.storage.StorageIoCore;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FileService {

    @Value("${password}")
    private String PASSWORD;

    @Value("${save.dir}")
    private String SAVE_PATH_STR;

    private final Path SAVE_DIR = Paths.get(SAVE_PATH_STR);

    private final StorageIoCore storageIoCore;

    public void uploadFile(
            final List<MultipartFile> multipartFiles,
            final String password
    ) {

        // 1) null 검사
        if (multipartFiles == null || multipartFiles.isEmpty()) {
            throw new CustomException(ExceptionCode.INVALID_FILE);
        }

        if (password == null || password.isBlank()) {
            throw new CustomException(ExceptionCode.INVALID_REQUEST);
        }

        // 2) 비밀 번호 검사
        if (!password.equals(PASSWORD)) {
            throw new CustomException(ExceptionCode.PASSWORD_INCORRECT);
        }

        // 3) 파일 저장
        for (final MultipartFile multipartFile : multipartFiles) {
            storageIoCore.write(multipartFile, SAVE_DIR);
        }
    }
}
