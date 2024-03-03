package org.example;

import java.util.*;

/**
 * Класс коллекция, похожая на HashMap
 */

public class SimpleHashMap<K, V> {
    private Entry<K, V>[] table;
    private int capacity = 16; // Начальный размер массива

    @SuppressWarnings("unchecked")
    public SimpleHashMap() {
        table = new Entry[capacity];
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    public void put(K key, V value) {
        int hash = hash(key);
        Entry<K, V> newEntry = new Entry<K, V>(key, value, null);

        if (table[hash] == null) {
            table[hash] = newEntry;
        } else {
            Entry<K, V> previous = null;
            Entry<K, V> current = table[hash];

            while (current != null) {
                if (current.key.equals(key)) {
                    current.value = value;
                    return;
                }
                previous = current;
                current = current.next;
            }
            if (previous != null) {
                previous.next = newEntry;
            }
        }
    }

    public Set<K> keySet() {
        Set<K> keySet = new HashSet<>();

        for (Entry<K, V> entry : table) {
            Entry<K, V> current = entry;
            while (current != null) {
                keySet.add(current.key);
                current = current.next;
            }
        }
        return keySet;
    }

    public V get(K key) {
        int hash = hash(key);
        if (table[hash] == null) {
            return null;
        } else {
            Entry<K, V> temp = table[hash];
            while (temp != null) {
                if (temp.key.equals(key))
                    return temp.value;
                temp = temp.next; // продолжаем по цепочке
            }
            return null; // в случае отсутствия ключа
        }
    }

    public boolean remove(K key) {
        int hash = hash(key);
        if (table[hash] == null) {
            return false;
        } else {
            Entry<K, V> previous = null;
            Entry<K, V> current = table[hash];

            while (current != null) {
                if (current.key.equals(key)) {
                    if (previous == null) {
                        table[hash] = current.next;
                    } else {
                        previous.next = current.next;
                    }
                    return true;
                }
                previous = current;
                current = current.next;
            }
            return false;
        }
    }

    //класс Entry будет представлять собой элемент списка,
    // хранящегося в каждом сегменте хеш-таблицы
    public static class Entry<K, V> {
        final K key;
        V value;
        Entry<K, V> next;

        public Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    //Тестирование программы
    public static void main(String[] args) {
        SimpleHashMap<String, Integer> map = new SimpleHashMap<>();

        // Добавляем элементы
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);

        //Вывод всей мапы
        for (String key : map.keySet()) {
            System.out.println("Key: " + key + ", Value: " + map.get(key));
        }

        // Чтение значений по ключам
        System.out.println("Value for key 'Two': " + map.get("Two"));
        System.out.println("Value for key 'Four': " + map.get("Four"));

        // Обновление значения
        map.put("One", 10);
        System.out.println("Updated value for key 'One': " + map.get("One"));

        // Удаление элемента
        map.remove("Two");
        System.out.println("Value for key 'Two' after removal: " + map.get("Two"));

        //Проверка всей мапы после всех CRUD-операций
        for (String key : map.keySet()) {
            System.out.println("Key: " + key + ", Value: " + map.get(key));
        }
    }
}