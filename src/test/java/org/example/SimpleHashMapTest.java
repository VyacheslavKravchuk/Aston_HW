package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SimpleHashMapTest {

    @Test
    public void testPutAndGet() {
        SimpleHashMap<Integer, String> map = new SimpleHashMap<>();
        map.put(1, "One");
        map.put(2, "Two");

        assertEquals("One", map.get(1));
        assertEquals("Two", map.get(2));
        assertNull(map.get(3)); // Проверка, что для несуществующего ключа возвращает null
    }

    @Test
    public void testKeySet() {
        SimpleHashMap<Integer, String> map = new SimpleHashMap<>();
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");

        assertEquals(3, map.keySet().size());
        assertTrue(map.keySet().contains(1));
        assertTrue(map.keySet().contains(2));
        assertTrue(map.keySet().contains(3));
    }

    @Test
    public void testRemove() {
        SimpleHashMap<Integer, String> map = new SimpleHashMap<>();
        map.put(1, "One");
        map.put(2, "Two");

        assertTrue(map.remove(1));
        assertFalse(map.remove(3)); // Проверка, что удаление несуществующего ключа возвращает false
        assertNull(map.get(1)); // Проверка удаления элемента
    }
}
