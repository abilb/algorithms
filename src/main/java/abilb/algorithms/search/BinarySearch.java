package abilb.algorithms.search;

public class BinarySearch {

  public static int recursive(int[] arr, int x, int left, int right) {
    if (left > right)
      return -1;

    int mid = left + (right - left) / 2;

    if (arr[mid] == x)
      return mid;
    else if (x < arr[mid])
      return recursive(arr, x, left, mid - 1);
    else
      return recursive(arr, x, mid + 1, right);
  }

  public static int iterative(int[] arr, int x) {
    int n = arr.length;
    int left = 0;
    int right = n - 1;

    while (left <= right) {
      int mid = left + (right - left) / 2;

      if (x == arr[mid])
        return mid;
      else if (x < arr[mid])
        right = mid - 1;
      else
        left = mid + 1;
    }

    return -1;
  }
}
