package com.bootcamp.bootcampmanager.student;

import com.bootcamp.bootcampmanager.bootcamp.Bootcamp;
import com.bootcamp.bootcampmanager.lecturer.Lecturer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImp implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public void saveStudent(Student student) {
        this.studentRepository.save(student);
    }

    @Override
    public Student getStudentById(long id) {
        Optional<Student> optional = studentRepository.findById(id);
        Student student;
        if (optional.isPresent()) {
            student = optional.get();
        } else {
            throw new RuntimeException("Not found student: " + id);
        }
        student.setTrainerName(findLecturer(student));
        return student;
    }

    @Override
    public void deleteStudentById(long id) {
        this.studentRepository.deleteById(id);
    }

    @Override
    public List<Student> getStudentByBootcampIdAndTaskId(Long campId, Long taskId) {
        List<Student> collect = getAllStudents().stream()
                .filter(student -> student.getBootcamp().getId() == campId)
                .filter(student -> student.getTasks()
                        .stream()
                        .anyMatch(task -> task.getId() == taskId))
                .collect(Collectors.toList());
        return collect;
    }

    private String findLecturer(Student student) {
        if (student.getBootcamp() != null) {
            Optional<Lecturer> optLecturer = student.getBootcamp().
                    getCampLecturers().stream().
                    filter(lecturer -> lecturer.isTrainer()).findFirst();
            return optLecturer.map(lecturer -> lecturer.getFirstName() + " " + lecturer.getLastName()).
                    orElse("Not Found");
        }
        return "";
    }
}

