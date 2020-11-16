package com.songor.blog.snippet.algorithm;

import java.util.Arrays;

/**
 * 实现一个支持动态扩容的数组
 *
 * @author chensongyu
 */
public class DynamicExpansionArrayList<T> {
  private static final int DEFAULT_CAPACITY = 10;

  private Object[] elements;

  private int size = 0;

  public DynamicExpansionArrayList() {
    elements = new Object[DEFAULT_CAPACITY];
  }

  public DynamicExpansionArrayList(int capacity) {
    if (capacity > 0) {
      elements = new Object[capacity];
    } else {
      elements = new Object[DEFAULT_CAPACITY];
    }
  }

  public void add(T element) {
    elements[size++] = element;

    if (size >= elements.length) {
      elements = Arrays.copyOf(elements, elements.length * 3 / 2);
    }
  }

  @SuppressWarnings("unchecked")
  public T get(int index) {
    if (index >= size) {
      throw new IndexOutOfBoundsException();
    }
    return (T) elements[index];
  }

  public int size() {
    return size;
  }

  public Object[] toArray() {
    return Arrays.copyOf(elements, size);
  }
}
