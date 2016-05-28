package com.michaelcane;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MySetTest {

    MySet<String> mySet;
    @Before
    public void setup() {
        mySet = new MySet<>();
    }

    @Test
    public void addObject() throws Exception {
        String expected = "Oh yeah";
        mySet.add("Oh yeah");
        String actual = mySet.get(0);
        assertEquals(expected, actual);
    }

    @Test
    public void addToIndex() throws Exception {
        String expected = "2";
        mySet.add(0, "1");
        mySet.add(1, "2");
        String actual = mySet.get(1);
        assertEquals(expected, actual);
    }

    @Test
    public void set() throws Exception {
        mySet.add(0, "What?");
        mySet.add(1, "Now?");
        mySet.add(2, "Seriously?");
        mySet.add(3, "We're doing this.");
        mySet.set(1, "Yeah, now");
        String expected = "Yeah, now";
        String actual = mySet.get(1);
        assertEquals(expected, actual);
    }

}