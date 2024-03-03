package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CustomArrayListTest {

    @Test
    public void testAddElement() {
        CustomArrayList<Integer> list = new CustomArrayList<>();
        list.add(5);
        assertEquals(1, list.getSize());
    }

    @Test
    public void testGetElement() {
        CustomArrayList<String> list = new CustomArrayList<>();
        list.add("Test");
        assertEquals("Test", list.get(0));
    }

    @Test
    public void testRemoveElement() {
        CustomArrayList<Double> list = new CustomArrayList<>();
        list.add(3.14);
        list.add(2.71);
        list.remove(0);
        assertEquals(1, list.getSize());
    }

    @Test
    public void testIndexOfElement() {
        CustomArrayList<Character> list = new CustomArrayList<>();
        list.add('A');
        list.add('B');
        list.add('C');
        assertEquals(1, list.indexOf('B'));
    }

    @Test
    public void testSelectionSort() {
        CustomArrayList<Integer> list = new CustomArrayList<>();
        list.add(5);
        list.add(2);
        list.add(8);
        list.selectionSort();
        assertEquals(2, list.get(0).intValue());
        assertEquals(5, list.get(1).intValue());
        assertEquals(8, list.get(2).intValue());
    }

}