package com.michaelcane;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyArrayListTest {

    MyArrayList<String> myArrayList;

    @Before
    public void setUp() throws Exception {
        myArrayList = new MyArrayList<>();
    }

    @Test
    public void myArrayListTest() {
        myArrayList = new MyArrayList<>();
        int expected = 0;
        int actual = myArrayList.size();
        assertEquals(expected, actual);
    }

    @Test
    public void myArrayListConstructorTest() {
        myArrayList = new MyArrayList<>(5);
        myArrayList.add("yeah BOIIIII");
        int expected = 1;
        int actual = myArrayList.size();
        assertEquals(expected, actual);
    }

    @Test
    public void add() throws Exception {
        String expected = "Oh yeah";
        myArrayList.add("Oh yeah");
        String actual = myArrayList.get(0);
        assertEquals(expected, actual);
    }

    @Test
    public void addAtIndex() throws Exception {
        String expected = "Oh yeah";
        myArrayList.add(0, "What?");
        myArrayList.add(1, "Oh yeah");
        String actual =  myArrayList.get(1);
        assertEquals(expected, actual);
    }

    @Test
    public void clear() throws Exception {
        int expected = 0;
        myArrayList.add(0, "What?");
        myArrayList.add(1, "Now?");
        myArrayList.add(2, "Seriously?");
        myArrayList.add(3, "We're doing this.");
        myArrayList.clear();
        int actual = myArrayList.size();
        assertEquals(expected, actual);
    }

    @Test
    public void contains() throws Exception {
        boolean expected = true;
        myArrayList.add(0, "What?");
        myArrayList.add(1, "Now?");
        myArrayList.add(2, "Seriously?");
        myArrayList.add(3, "We're doing this.");
        boolean actual = myArrayList.contains("Now?");
        assertEquals(expected, actual);
    }

    @Test
    public void get() throws Exception {
        String expected = "Oh yeah";
        myArrayList.add("Oh yeah");
        String actual = myArrayList.get(0);
        assertEquals(expected, actual);
    }

    @Test
    public void indexOf() {
        int expected = 1;
        myArrayList.add(0, "What?");
        myArrayList.add(1, "Now?");
        myArrayList.add(2, "Seriously?");
        myArrayList.add(3, "We're doing this.");
        int actual = myArrayList.indexOf("Now?");
        assertEquals(expected, actual);
    }

    @Test
    public void indexOfEmpty() {
        int expected = -1;
        myArrayList.add(0, "What?");
        myArrayList.add(1, "Now?");
        myArrayList.add(2, "Seriously?");
        myArrayList.add(3, "We're doing this.");
        int actual = myArrayList.indexOf("Green World");
        assertEquals(expected, actual);
    }

    @Test
    public void isNotEmpty() throws Exception {
        boolean expected = false;
        myArrayList.add(0, "What?");
        myArrayList.add(1, "Now?");
        myArrayList.add(2, "Seriously?");
        myArrayList.add(3, "We're doing this.");
        boolean actual = myArrayList.isEmpty();
        assertEquals(expected, actual);
    }

    @Test
    public void isActuallyEmpty() throws Exception {
        boolean expected = true;
        myArrayList.add(0, "What?");
        myArrayList.add(1, "Now?");
        myArrayList.add(2, "Seriously?");
        myArrayList.add(3, "We're doing this.");
        myArrayList.clear();
        boolean actual = myArrayList.isEmpty();
        assertEquals(expected, actual);
    }

    @Test
    public void removeAtIndex() throws Exception {
        String expected = "We're doing this.";
        myArrayList.add(0, "What?");
        myArrayList.add(1, "Now?");
        myArrayList.add(2, "Seriously?");
        myArrayList.add(3, "We're doing this.");
        myArrayList.add(4, "Oh yeah!");
        System.out.println(myArrayList.size());
        String actual = myArrayList.remove(3);
        System.out.println(myArrayList.size());
        assertEquals(expected, actual);
    }

    @Test
    public void removeObject() throws Exception {
        myArrayList.add(0, "What?");
        myArrayList.add(1, "Now?");
        myArrayList.add(2, "Seriously?");
        myArrayList.add(3, "We're doing this.");
        myArrayList.add(4, "Oh yeah!");
        boolean isTrue = myArrayList.remove("Seriously?");
        assertTrue(isTrue);
    }

    @Test
    public void set() throws Exception {
        String expected = "Oh yeah";
        myArrayList.add(0, "What?");
        myArrayList.add(1, "Now?");
        myArrayList.add(2, "Seriously?");
        myArrayList.add(3, "We're doing this.");
        myArrayList.set(3, "Oh yeah");
        String actual = myArrayList.get(3);
        assertEquals(expected, actual);
    }

}