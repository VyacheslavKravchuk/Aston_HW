package org.example;
import java.util.Arrays;

/**
 * Класс коллекция, похожая на ArrayList
 */

public class CustomArrayList<T> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    public CustomArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public int getSize() {
        return size;
    }

    public Object[] getElements() {
        return elements;
    }

    public void add(T element) {
        if (size == elements.length) {
            increaseCapacity();
        }
        elements[size++] = element;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index);
        }
        return (T) elements[index];
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + size);
        }

        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }

        size--;
        elements[size] = null;
    }

    public int indexOf(T element) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    private void increaseCapacity() {
        int newCapacity = elements.length * 2;
        elements = Arrays.copyOf(elements, newCapacity);
    }

    //Создаем метод для сортировки выбором
    @SuppressWarnings("unchecked")
    public void selectionSort() {
        int n = size;

        for (int i = 0; i < n-1; i++) {
            int minIndex = i;
            for (int j = i+1; j < n; j++) {
                Comparable<T> currentValue = (Comparable<T>) elements[j];
                Comparable<T> minValue = (Comparable<T>) elements[minIndex];
                if (currentValue.compareTo((T) minValue) < 0) {
                    minIndex = j;
                }
            }
            T temporary = (T) elements[minIndex];
            elements[minIndex] = elements[i];
            elements[i] = temporary;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CustomArrayList{size=").append(size).append(", elements=[");
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]}");
        return sb.toString();
    }

}
