package ru.geekbrains.samples.lesson1.task3;

public class Square extends Figure{
    float side;

    @Override
    void draw() {
        draw(side);
    }

    private void draw(float side) {
        System.out.printf("draw Square with side = %s",side);
    }
}