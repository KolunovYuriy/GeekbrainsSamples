package ru.geekbrains.samples.web.repository;

import ru.geekbrains.samples.web.domain.Student;

import javax.persistence.EntityManager;

public class StudentCustomRepository extends AbstractRepository<Student,Long>{
    public StudentCustomRepository(EntityManager entityManager, Class<Student> type) {
        super(entityManager, type);
    }

}
