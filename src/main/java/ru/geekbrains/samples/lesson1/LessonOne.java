package ru.geekbrains.samples.lesson1;

public class LessonOne {
    public static void main(String[] args) {
        PersonBuilder builder = new PersonBuilder();
        builder.firstName("Ivan").lastName("Ivanov").middleName("Ivanovich").country("Russia").address("Tverskaya st., 1, 1").phone("+7(999)999-99-99").age(30).gender("men");
        System.out.println(builder.build());
    }
}
