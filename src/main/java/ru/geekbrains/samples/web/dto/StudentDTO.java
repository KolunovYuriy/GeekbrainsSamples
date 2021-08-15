package ru.geekbrains.samples.web.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrains.samples.web.domain.Student;

@Data
@NoArgsConstructor
public class StudentDTO {
    private long id;
    private String name;
    private int mark;
    private int age;
    public StudentDTO (Student student) {
        id = student.getId();
        name = student.getName();
        mark = student.getMark();
        age = student.getAge();
    }
}
