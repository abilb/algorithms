package abilb.algorithms.datastructures;

import java.util.Arrays;

@SuppressWarnings("unchecked")
public class MyArrayList<T> {

  private static final int DEFAULT_CAPACITY = 8;
  private static final int RESIZE_FACTOR = 2;

  private Object[] data;
  private int size;
  private int capacity;

  public MyArrayList() {
    this(DEFAULT_CAPACITY);
  }

  public MyArrayList(int capacity) {
    if (capacity < 0)
      throw new IllegalArgumentException("Capacity must be greater than or equal to zero");

    this.capacity = capacity;
    this.size = 0;
    data = new Object[capacity];
  }

  public void add(T e) {
    if (size + 1 >= capacity) {
      capacity = capacity == 0 ? DEFAULT_CAPACITY : capacity * RESIZE_FACTOR;

      Object[] data2 = new Object[capacity];

      for (int i = 0; i < size; i++)
        data2[i] = data[i];

      data = data2;
    }

    data[size] = e;
    size++;
  }

  public void update(int index, T e) {
    if (index < 0 || index >= size())
      throw new IndexOutOfBoundsException();
    data[index] = e;
  }

  public boolean remove(Object o) {
    int i = indexOf(o);

    if (i == -1)
      return false;

    remove(i);
    return true;
  }

  public boolean containsOf(Object o) {
    return indexOf(o) >= 0;
  }

  public boolean remove(int index) {
    if (index < 0 || index >= size)
      throw new IndexOutOfBoundsException();

    Object[] data2 = new Object[size - 1];

    for (int p1 = 0, p2 = 0; p1 < size; p1++, p2++) {
      if (p1 == index) {
        p2--;
        continue;
      }

      data2[p2] = data[p1];
    }

    data = data2;
    size = size - 1;
    capacity = size;

    return true;
  }

  public int indexOf(Object o) {
    if (o == null) {
      for (int i = 0; i < size(); i++)
        if (data[i] == null)
          return i;
    } else {
      for (int i = 0; i < size(); i++)
        if (o.equals(data[i]))
          return i;
    }

    return -1;
  }


  public T get(int index) {
    if (index < 0 || index >= size)
      throw new IndexOutOfBoundsException();

    return (T) data[index];
  }

  @Override
  public String toString() {
    if (size() == 0)
      return "[]";

    StringBuilder s = new StringBuilder();
    s.append('[');

    for (int i = 0; i < size() - 1; i++)
      s.append(data[i] + ", ");

    s.append(data[size() - 1] + "]");
    return s.toString();
  }

  // Returns the number of elements in this list.
  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size() == 0;
  }

}
