package com.michaelcane;

public class MySet<E> extends MyArrayList<E> {

    public MySet() {
        super();
    }

    @Override
    public boolean add(Object o) {
        if(!super.contains(o)) {
            super.add(o);
        }
        return true;
    }

    @Override
    public void add(int index, Object o) {
        if(!super.contains(o)) {
            super.add(index, o);
        }
    }

    @Override
    public E set(int index, Object o) {
        if (!super.contains(o)) {
            super.set(index, o);
        }
        return null;
    }

}
