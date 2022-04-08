package com.bootcamp.bootcampmanager.filedb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class FileDBController {

    @Autowired
    private FileDBService fileDBService;

    @GetMapping("/task")
    public String getFiles(Model model) {
        List<FileDB> filesList = fileDBService.getFiles();
        model.addAttribute("filesList", filesList);
        return "task";
    }

    /* Make single file upload */
    @PostMapping("/uploadFiles")
    public String uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        for (MultipartFile file: files) {
            fileDBService.saveFile(file);
        }
        return "redirect:/task";
    }

    @GetMapping("/download/{fileId}")
    public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable Long fileId){
        FileDB fileDB = fileDBService.getFile(fileId).get();
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(fileDB.getType()))
                .header(HttpHeaders.CONTENT_DISPOSITION,"attachment:filename=\"" + fileDB.getName()+"\"")
                .body(new ByteArrayResource(fileDB.getData()));
    }
}
