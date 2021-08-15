package ru.geekbrains.samples.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.samples.web.domain.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
}
