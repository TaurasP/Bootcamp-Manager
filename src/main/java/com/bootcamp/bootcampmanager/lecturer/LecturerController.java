package com.bootcamp.bootcampmanager.lecturer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class LecturerController {

    @Autowired
    private LecturerService lecturerService;
}
