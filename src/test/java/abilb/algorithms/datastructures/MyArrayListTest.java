package abilb.algorithms.datastructures;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class MyArrayListTest {

  @Test
  public void testEmpty() {
    MyArrayList<Byte> list = new MyArrayList<>();
    assertTrue(list.isEmpty());
  }

  @Test
  public void testRemovingEmpty() {
    MyArrayList<Integer> list = new MyArrayList<>();
    assertThrows(IndexOutOfBoundsException.class, () -> {
      list.remove(0);
    });
  }

  @Test
  public void testExceptions() {
    MyArrayList<Integer> list = new MyArrayList<>();
    for (int i = 0; i < 10; i++)
      list.add(1);

    assertThrows(IndexOutOfBoundsException.class, () -> {
      list.remove(-1);
    });

    assertThrows(IndexOutOfBoundsException.class, () -> {
      list.remove(-5);
    });

    assertThrows(IndexOutOfBoundsException.class, () -> {
      list.remove(10);
    });

    assertThrows(IndexOutOfBoundsException.class, () -> {
      list.update(-1, 5);
    });

    assertThrows(IndexOutOfBoundsException.class, () -> {
      list.update(10, 5);
    });

    assertThrows(IndexOutOfBoundsException.class, () -> {
      list.update(100, 5);
    });

    assertThrows(IndexOutOfBoundsException.class, () -> {
      list.get(-5);
    });

    assertThrows(IndexOutOfBoundsException.class, () -> {
      list.get(10);
    });

    assertThrows(IndexOutOfBoundsException.class, () -> {
      list.get(100);
    });
  }

  @Test
  public void testRemoving() {

    MyArrayList<String> list = new MyArrayList<>();
    String[] strs = {"abc", "xyz", "pq", null, "mn"};

    for (String s : strs)
      list.add(s);

    boolean ret = list.remove("abc");
    assertTrue(ret);

    ret = list.remove("abc");
    assertFalse(ret);

    ret = list.remove("mn");
    assertTrue(ret);

    ret = list.remove("mn");
    assertFalse(ret);

    ret = list.remove("xyz");
    assertTrue(ret);

    ret = list.remove("pq");
    assertTrue(ret);

    ret = list.remove(null);
    assertTrue(ret);

    ret = list.remove("xyz");
    assertFalse(ret);

    ret = list.remove("pq");
    assertFalse(ret);

    ret = list.remove(null);
    assertFalse(ret);
  }

  @Test
  public void testNull() {
    MyArrayList<String> list = new MyArrayList<>();

    String[] strArr = {"abc", "xyz", null, "pq"};

    for (String str : strArr)
      list.add(str);

    assertTrue(list.indexOf(null) == 2);
  }

  @Test
  public void testAdding() {

    MyArrayList<Integer> list = new MyArrayList<>();

    int[] integers = {10, 20, 30, 40};

    for (int i = 0; i < integers.length; i++)
      list.add(integers[i]);

    for (int i = 0; i < integers.length; i++)
      assertEquals(list.get(i).intValue(), integers[i]);
  }

  @Test
  public void testAddRemove() {

    MyArrayList<Long> list = new MyArrayList<>(0);

    for (int i = 0; i < 10; i++)
      list.add(5L);

    for (int i = 0; i < 10; i++)
      list.remove(5L);

    assertTrue(list.isEmpty());

    for (int i = 0; i < 10; i++)
      list.add(5L);

    for (int i = 0; i < 10; i++)
      list.remove(0);

    assertTrue(list.isEmpty());
  }

  @Test
  public void testSize() {

    MyArrayList<Integer> list = new MyArrayList<>();

    Integer[] elems = {-7, 5, 6, 3, null, 4, 2};

    for (int i = 0, size = 1; i < elems.length; i++, size++) {
      list.add(elems[i]);
      assertEquals(list.size(), size);
    }
  }
}
