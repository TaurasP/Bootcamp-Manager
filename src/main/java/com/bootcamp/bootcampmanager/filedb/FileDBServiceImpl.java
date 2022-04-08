package com.bootcamp.bootcampmanager.filedb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
public class FileDBServiceImpl implements FileDBService{

    @Autowired
    private FileDBRepository fileDBRepository;

    public FileDB saveFile(MultipartFile file) {
        String docname = file.getOriginalFilename();
        try {
            FileDB doc = new FileDB(docname,file.getContentType(),file.getBytes());
            return fileDBRepository.save(doc);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public Optional<FileDB> getFile(Long fileId) {
        return fileDBRepository.findById(fileId);
    }
    public List<FileDB> getFiles(){
        return fileDBRepository.findAll();
    }
}
