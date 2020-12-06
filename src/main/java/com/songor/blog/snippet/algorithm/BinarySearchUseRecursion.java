package com.songor.blog.snippet.algorithm;

/**
 * 二分查找
 *
 * @author chensongyu
 */
public class BinarySearchUseRecursion implements Search {
  @Override
  public int search(int[] arr, int n, int value) {
    return recursion(arr, 0, n - 1, value);
  }

  private int recursion(int[] arr, int start, int end, int value) {
    if (start > end) {
      return -1;
    }

    int middle = start + (end - start) / 2;
    if (arr[middle] == value) {
      return middle;
    } else if (arr[middle] < value) {
      return recursion(arr, middle + 1, end, value);
    } else {
      return recursion(arr, start, middle - 1, value);
    }
  }
}
