package ru.geekbrains.samples.lesson2;

public class LessonTwo {
    public static void main(String[] args) {
        //-task1------------------//
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
        //------------------------//
        DoubleWayLinkedList dwll = new DoubleWayLinkedList();
        dwll.insertLast(new Cat(5, "Marsel"));
        dwll.push(new Cat(4, "Vasya"));
        dwll.push(new Cat(3, "Matroskin"));
        dwll.push(new Cat(2, "Q"));
        dwll.push(new Cat(1, "Murzik"));
        dwll.insertLast(new Cat(6, "Petya"));
        DoubleWayLinkedList.IteroCat it2 = dwll.iterator();
        while(it2.hasNext()) {
            Cat c = it2.next();
            System.out.println(c);
        }

        //-task2------------------//

    }
}
