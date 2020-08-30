package abilb.algorithms.search;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class BinarySearchTest {
  @Test
  public void testVariousCases() {
    int[] expects = new int[25];
    int[] find = new int[25];
    int[][] cases = new int[25][];

    cases[0] = new int[] {-10, -5, 0, 1, 2, 3, 4, 5, 10, 20};
    find[0] = -11;
    expects[0] = -1;

    cases[1] = new int[] {-10, -5, 0, 1, 2, 3, 4, 5, 10, 20};
    find[1] = -10;
    expects[1] = 0;

    cases[2] = new int[] {-10, -5, 0, 1, 2, 3, 4, 5, 10, 20};
    find[2] = 20;
    expects[2] = 9;

    cases[3] = new int[] {-10, -5, 0, 1, 2, 3, 4, 5, 10, 20};
    find[3] = 2;
    expects[3] = 4;

    cases[4] = new int[] {-10, -5, 0, 1, 2, 3, 4, 5, 10, 20};
    find[4] = 0;
    expects[4] = 2;

    cases[5] = new int[] {-10, -5, 0, 1, 2, 3, 4, 5, 10, 20};
    find[5] = 10;
    expects[5] = 8;

    cases[6] = new int[] {1, 2, 3, 4, 5};
    find[6] = 1;
    expects[6] = 0;

    cases[7] = new int[] {1, 2, 3, 4, 5};
    find[7] = 2;
    expects[7] = 1;

    cases[8] = new int[] {1, 2, 3, 4, 5};
    find[8] = 3;
    expects[8] = 2;

    cases[9] = new int[] {1, 2, 3, 4, 5};
    find[9] = 4;
    expects[9] = 3;

    cases[10] = new int[] {1, 2, 3, 4, 5};
    find[10] = 5;
    expects[10] = 4;

    cases[11] = new int[] {1, 2, 3, 4, 5};
    find[11] = 0;
    expects[11] = -1;

    cases[12] = new int[] {1};
    find[12] = 0;
    expects[12] = -1;

    cases[13] = new int[] {1};
    find[13] = 1;
    expects[13] = 0;

    cases[14] = new int[] {1, 2};
    find[14] = 0;
    expects[14] = -1;

    cases[15] = new int[] {1, 2};
    find[15] = 1;
    expects[15] = 0;

    cases[16] = new int[] {1, 2};
    find[16] = 2;
    expects[16] = 1;

    for (int i = 0; i < cases.length; i++) {
      if (cases[i] == null)
        break;

      int expect = expects[i];
      int x = find[i];
      int[] input = cases[i];

      int left = 0;
      int right = input.length - 1;
      int actual = BinarySearch.recursive(input, x, left, right);
      assertEquals(expect, actual, "recursive(" + Arrays.toString(input) + ") - expected:" + expect + ", actual: " + actual);

      actual = BinarySearch.iterative(input, x);
      assertEquals(expect, actual, "iterative(" + Arrays.toString(input) + ") - expected:" + expect + ", actual: " + actual);
    }
  }
}
