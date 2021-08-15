package ru.geekbrains.samples.web.controller;

import org.springframework.web.bind.annotation.*;
import ru.geekbrains.samples.web.dto.StudentDTO;
import ru.geekbrains.samples.web.exeptions.ResourceNotFoundException;
import ru.geekbrains.samples.web.services.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

    final private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    //http://localhost:8195/students/{id}
    @GetMapping("/{id}")
    public StudentDTO getById(@PathVariable Long id) {
        return new StudentDTO(studentService.getById(id).orElseThrow(() -> new ResourceNotFoundException("Student with id: " + id + " doesn't exist")));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        studentService.deleteById(id);
    }

    @PostMapping
    public StudentDTO add(@RequestBody StudentDTO studentDTO) {
        return studentService.addStudent(studentDTO);
    }

    @PutMapping
    public StudentDTO update(@RequestBody StudentDTO studentDTO) {
        if (studentDTO.getId()<=0) {
            throw new ResourceNotFoundException("doesn't insert Student id");
        }
        return new StudentDTO(studentService.updateStudent(studentDTO));
    }

}
