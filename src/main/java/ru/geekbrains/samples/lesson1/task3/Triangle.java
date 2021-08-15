package ru.geekbrains.samples.lesson1.task3;

public class Triangle extends Figure{
    float x1;
    float y1;
    float x2;
    float y2;
    float x3;
    float y3;

    @Override
    void draw() {
        draw(x1,y1,x2,y2,x3,y3);
    }

    private void draw(float x1, float y1, float x2, float y2, float x3, float y3) {
        System.out.println("draw Triangle");
    }
}