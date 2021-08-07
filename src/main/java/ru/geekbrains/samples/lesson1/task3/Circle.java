package ru.geekbrains.samples.lesson1.task3;

public class Circle extends Figure{
    float radius;

    @Override
    void draw() {
        draw(radius);
    }

    private void draw(float radius) {
        System.out.printf("draw circle with radius = %s",radius);
    }
}
