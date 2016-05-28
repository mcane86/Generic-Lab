package com.michaelcane;

import java.util.Arrays;

public class MyArrayList<E> {

    public Object[] elementList;

    private static final int DEFAULT_CAPACITY = 10;

    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTLIST = {};

    private static final Object[] EMPTY_ELEMENTLIST = {};

    private int size;

    public MyArrayList() {
        this.elementList = EMPTY_ELEMENTLIST;
    }

    public MyArrayList(int initialSize) {
        if (initialSize > 0) {
            this.elementList = new Object[initialSize];
        } else if (initialSize == 0) {
            this.elementList = EMPTY_ELEMENTLIST;
        } else {
            throw new IllegalArgumentException("Illegal capacity: " + initialSize);
        }
    }

    public boolean add(Object o) {
        ensureCapacityInternal(size + 1);
        elementList[size++] = o;
        return true;
    }

    public void add(int index, Object o) {
        rangeCheckToAdd(index);

        ensureCapacityInternal(size + 1);
        elementList[size++] = o;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            elementList[i] = null;
        }
        size = 0;
    }

    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    private E elementList(int index) {
        return (E) elementList[index];
    }

    private void ensureCapacityInternal(int minCapacity){
        if (elementList == DEFAULTCAPACITY_EMPTY_ELEMENTLIST) {
            minCapacity = Math.max(minCapacity, DEFAULT_CAPACITY);
        }
        ensureExplicitCapacity(minCapacity);
    }

    private void ensureExplicitCapacity(int minCapacity) {
        if(minCapacity - elementList.length > 0) {
            grow(minCapacity);
        }
    }

    private void fastRemove(int index) {
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elementList, index + 1, elementList, index, numMoved);
        }
        elementList[--size] = null;
    }

    public E get(int index) {
        rangeCheck(index);
        return elementList(index);
    }

    private void grow(int minCapacity) {
        int oldCapacity = elementList.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - minCapacity < 0) {
            newCapacity = minCapacity;
        }
        elementList = Arrays.copyOf(elementList, newCapacity);
    }

    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elementList[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(elementList[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+size;
    }

    private void rangeCheck(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    private void rangeCheckToAdd(int index) {
        if(index > size || index < 0) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    public boolean remove(Object o) {
        if (o == null) {
            for (int index = 0; index < size; index++) {
                if (o.equals(elementList(index))) {
                    fastRemove(index);
                    return true;
                }
            }
        } else {
            for (int index = 0; index < size; index++) {
                if (o.equals(elementList(index))) {
                    fastRemove(index);
                    return true;
                }
            }
        }
        return false;
    }


    public E remove(int index) {
        rangeCheck(index);
        E oldValue = elementList(index);
        fastRemove(index);
        return oldValue;
    }

    public E set(int index, Object o) {
        rangeCheck(index);
        E oldValue = elementList(index);
        elementList[index] = o;
        return oldValue;
    }

    public int size() {
        return size;
    }
}
