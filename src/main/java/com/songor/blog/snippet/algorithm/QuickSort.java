package com.songor.blog.snippet.algorithm;

/**
 * 快速排序
 *
 * @author chensongyu
 */
public class QuickSort implements Sort {
  @Override
  public void sort(int[] arr, int n) {
    recursion(arr, 0, n - 1);
  }

  private void recursion(int[] arr, int start, int end) {
    if (start >= end) {
      return;
    }

    int middle = partition(arr, start, end);
    recursion(arr, start, middle - 1);
    recursion(arr, middle + 1, end);
  }

  private int partition(int[] arr, int start, int end) {
    int pivot = arr[end], i = start, j = start;
    while (j < end) {
      if (arr[j] < pivot) {
        swap(arr, i, j);
        i++;
      }
      j++;
    }
    swap(arr, i, end);
    return i;
  }

  private void swap(int[] arr, int i, int j) {
    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }
}
