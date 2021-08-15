package ru.geekbrains.samples.web.services;

import org.springframework.stereotype.Service;
import ru.geekbrains.samples.web.domain.Student;
import ru.geekbrains.samples.web.dto.StudentDTO;
import ru.geekbrains.samples.web.exeptions.ResourceNotFoundException;
import ru.geekbrains.samples.web.repository.StudentRepository;

import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Optional<Student> getById(Long id) {
        return Optional.of(studentRepository.getById(id));
    }

    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

    public StudentDTO addStudent(StudentDTO studentDTO) {
        return new StudentDTO(studentRepository.save(createStudentFromStudentDTO(studentDTO)));
    }

    public Student updateStudent(StudentDTO studentDTO) {

        Student student = getById(studentDTO.getId()).orElseThrow(() -> new ResourceNotFoundException("Student with id: " + studentDTO.getId() + " doesn't exist"));

        if (!studentDTO.getName().equals("")) {
            student.setName(studentDTO.getName());
        }
        if (studentDTO.getMark()!=0) {
            student.setMark(studentDTO.getMark());
        }
        if (studentDTO.getAge()!=0) {
            student.setAge(studentDTO.getAge());
        }
        return studentRepository.save(student);
    }

    private Student createStudentFromStudentDTO(StudentDTO studentDTO) {
        return new Student(studentDTO.getId(),studentDTO.getName(),studentDTO.getMark(),studentDTO.getAge());
    }
}
