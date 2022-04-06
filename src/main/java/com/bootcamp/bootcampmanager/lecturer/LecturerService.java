package com.bootcamp.bootcampmanager.lecturer;

import java.util.List;

public interface LecturerService {

    public List<Lecturer> getAllLecturers();
    public void saveLecturer(Lecturer lecturer);
    public Lecturer getLecturerById(long id);
    public void deleteLecturerById(long id);
}
