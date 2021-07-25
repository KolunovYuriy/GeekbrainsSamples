package ru.geekbrains.samples.lesson2;

public class LessonTwo {
    public static void main(String[] args) {
        MyLinkedList sl = new MyLinkedList();
        sl.push(new Cat(4, "Vasya"));
        sl.push(new Cat(3, "Matroskin"));
        sl.push(new Cat(2, "Q"));
        sl.push(new Cat(1, "Murzik"));
        MyLinkedList.IteroCat it = sl.iterator();
        while(it.hasNext()) {
            Cat c = it.next();
            System.out.println(c);
        }
        it.reset();
        System.out.println(it.next());
        System.out.println(it.atEnd());
        System.out.println("-----------");
    }
}
