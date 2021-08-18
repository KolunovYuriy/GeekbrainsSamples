package ru.geekbrains.samples.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.geekbrains.samples.web.domain.Student;
import ru.geekbrains.samples.web.repository.StudentCustomRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Component
public class Test implements CommandLineRunner {

    final private boolean IS_RUN = true;

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    private static EntityManagerFactory entityManagerFactory;


    @Override
    @Transactional
    public void run(String... args) throws Exception {
        if (IS_RUN) {
            System.out.println("startTest");
            StudentCustomRepository repository = new StudentCustomRepository(entityManager, Student.class);
            for (int i=1;i<=1000;i++)
                repository.save(new Student(i, "Student " + i, (int) (6 * Math.random())));
            long removeId = (long)(500 * Math.random());
            // test findById and remove
            repository.remove(repository.findById(removeId));
            // test removeById and remove
            repository.removeById(removeId+500);
            // test findAll
            System.out.println(repository.findAll().get(5));
            System.out.println("stopTest");
        }
    }
}
