package com.bootcamp.bootcampmanager.filedb;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface FileDBService {
    public FileDB saveFile(MultipartFile file);
    public Optional<FileDB> getFile(Long fileId);
    public List<FileDB> getFiles();
}
