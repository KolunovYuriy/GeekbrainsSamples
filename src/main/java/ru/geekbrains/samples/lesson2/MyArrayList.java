package ru.geekbrains.samples.lesson2;

import java.util.*;

public class MyArrayList<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
    private static final byte MULTIPLIER = 2;

    private Object[] elementData;
    private int size;

    public MyArrayList(Object[] array) {
        this.size = array.length;
        this.elementData = Arrays.copyOf(array,array.length*MULTIPLIER);
    }

    public MyArrayList() {
        this.size = 0;
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    public int size() {
        return this.elementData.length;
    }

    public boolean isEmpty() {
        return this.elementData.equals(DEFAULTCAPACITY_EMPTY_ELEMENTDATA) ? true : false;
    }

    public boolean contains(Object o) {
        return Arrays.stream(this.elementData).anyMatch(currentObject -> currentObject.equals(o));
    }

    public Iterator iterator() {
        return null;
    }

    public Object[] toArray() {
        return this.elementData;
    }

    public boolean add(T t) {
        if (this.elementData.equals(DEFAULTCAPACITY_EMPTY_ELEMENTDATA)) {
            this.elementData = new Object[DEFAULT_CAPACITY];
            size = 0;
        }
        if (size==this.elementData.length) {
            resize();
        }
        elementData[++size] = t;
        return false;
    }

    public boolean remove(Object o) {
        boolean result = false;
        if (this.elementData.equals(DEFAULTCAPACITY_EMPTY_ELEMENTDATA)) {return false;}
        while (Arrays.stream(elementData).anyMatch(currentObject -> currentObject.equals(o))) {

            int index = 0;

            for (int i = 0; i < this.elementData.length; i++) {
                if (this.elementData[i].equals(o)) {
                    index = i;
                    break;
                }
            }
            remove(index);
            result = true;
        }
        return result;
    }

    public void clear() {
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    public Object get(int index) {
        return null;
    }

    public Object set(int index, Object element) {
        return null;
    }

    public void add(int index, Object element) {

    }

    public Object remove(int index) {
        Object result = null;
        if ((this.elementData.equals(DEFAULTCAPACITY_EMPTY_ELEMENTDATA)) || (index>=(size-1))) {return result;}
        result = this.elementData[index];
        for (int i = index; i < this.elementData.length -1; i++) {
            this.elementData[i] = this.elementData[i + 1];
        }
        this.elementData = Arrays.copyOf(this.elementData, this.elementData.length - 1);
        size--;
        return result;
    }

    public int indexOf(Object o) {
        return 0;
    }

    private void resize() {
        Arrays.copyOf(this.elementData,this.elementData.length*MULTIPLIER);
    }

    protected class IteratorMyArrayList implements Iterator {

        final private MyArrayList myArrayList;
        private int currentIndex;

        protected IteratorMyArrayList(MyArrayList myLinkedList) {
            this.myArrayList = myLinkedList;
            this.currentIndex = 0;
        }

        @Override
        public boolean hasNext() {
            return currentIndex != (myArrayList.size()-1);
        }

        @Override
        public Object next() {
            if (!hasNext()) return null;
            ++currentIndex;
            return myArrayList.get(++currentIndex);
        }

        public Object getCurrent() {
            return myArrayList.get(currentIndex);
        }

        public Object atEnd() {
            return myArrayList.get(myArrayList.size());
        }

        public void reset() {
            currentIndex = 0;
        }

    }

}
