package com.bootcamp.bootcampmanager.filedb;

import com.bootcamp.bootcampmanager.task.Task;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface FileDBService {
    FileDB saveFile(MultipartFile file, Task task);
    Optional<FileDB> getFile(Long fileId);
    List<FileDB> getFiles();
}
