package com.songor.blog.snippet.algorithm;

/**
 * 归并排序
 *
 * @author chensongyu
 */
public class MergeSort implements Sort {
  @Override
  public void sort(int[] arr, int n) {
    recursion(arr, 0, n - 1);
  }

  private void recursion(int[] arr, int start, int end) {
    if (start >= end) {
      return;
    }

    int middle = (start + end) / 2;
    recursion(arr, start, middle);
    recursion(arr, middle + 1, end);
    merge(arr, start, middle, end);
  }

  private void merge(int[] arr, int start, int middle, int end) {
    int[] tmp = new int[end - start + 1];
    int i = start, j = middle + 1, k = 0;
    while (i <= middle && j <= end) {
      if (arr[i] <= arr[j]) {
        tmp[k] = arr[i];
        i++;
      } else {
        tmp[k] = arr[j];
        j++;
      }
      k++;
    }
    while (i <= middle) {
      tmp[k] = arr[i];
      i++;
      k++;
    }
    while (j <= end) {
      tmp[k] = arr[j];
      j++;
      k++;
    }

    int p = start;
    while (p <= end) {
      arr[p] = tmp[p - start];
      p++;
    }
  }
}
