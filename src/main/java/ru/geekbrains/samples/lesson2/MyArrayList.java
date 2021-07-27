package ru.geekbrains.samples.lesson2;

import java.util.*;

public class MyArrayList<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
    private static final byte MULTIPLIER = 2;

    private Object elementData[];
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

    public IteratorMyArrayList iterator() {
        return new IteratorMyArrayList(this);
    }

    public Object[] toArray() {
        return this.elementData;
    }

    public boolean add(T t) {
        if (this.elementData.equals(DEFAULTCAPACITY_EMPTY_ELEMENTDATA)) {
            resize(DEFAULT_CAPACITY);
            this.size = 0;
        }
        if (this.size==this.elementData.length) {
            resize();
        }
        elementData[++this.size] = t;
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
        if ((this.elementData.equals(DEFAULTCAPACITY_EMPTY_ELEMENTDATA)) || (index>=(size-1))) {return null;}
        return this.elementData[index];
    }

    public Object set(int index, Object element) {
        Object result = null;
        if ((this.elementData.equals(DEFAULTCAPACITY_EMPTY_ELEMENTDATA)) || (index>=(size-1))) {resize(index+1);}
        result = this.elementData[index];
        this.elementData[index] = element;
        return result;
    }

    public void add(int index, Object element) {
        if ((this.elementData.equals(DEFAULTCAPACITY_EMPTY_ELEMENTDATA)) || (index>=(size-1))) {resize(index+2);}
        Object buffer = this.elementData[index];
        for (int i = index; i < this.elementData.length -1; i++) {
            this.elementData[i+1] = this.elementData[i];
        }
        this.elementData[index] = element;
        this.size++;
    }

    public Object remove(int index) {
        Object result = null;
        if ((this.elementData.equals(DEFAULTCAPACITY_EMPTY_ELEMENTDATA)) || (index>=(size-1))) {return result;}
        result = this.elementData[index];
        for (int i = index; i < this.elementData.length -1; i++) {
            this.elementData[i] = this.elementData[i + 1];
        }
        this.elementData = Arrays.copyOf(this.elementData, this.elementData.length - 1);
        this.size--;
        return result;
    }

    public int indexOf(Object o) {
        int result=-1;
        if (this.elementData.equals(DEFAULTCAPACITY_EMPTY_ELEMENTDATA)) return -1;
        for (int i = 0; i < this.size; i++) {
            if (this.elementData[i].equals(o)) {
                result = i;
                break;
            }
        }
        return result;
    }

    private void resize() {
        this.elementData = Arrays.copyOf(this.elementData,this.elementData.length*MULTIPLIER);
    }

    private void resize(int size) {
        this.elementData = Arrays.copyOf(this.elementData,size);
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
            return currentIndex <= (myArrayList.size()-1);
        }

        @Override
        public Object next() {
            if (!hasNext()) return null;
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
