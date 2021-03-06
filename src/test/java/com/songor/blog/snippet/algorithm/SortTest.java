package com.songor.blog.snippet.algorithm;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class SortTest {
  private final int[] ARR = {4, 5, 6, 1, 3, 2};

  private final int[] SORTED_ARR = {1, 2, 3, 4, 5, 6};

  @Test
  void bubbleSort() {
    BubbleSort bubbleSort = new BubbleSort();
    int[] arr = Arrays.copyOf(ARR, ARR.length);
    bubbleSort.sort(arr, arr.length);
    assertArrayEquals(SORTED_ARR, arr);
  }

  @Test
  void insertionSort() {
    InsertionSort insertionSort = new InsertionSort();
    int[] arr = Arrays.copyOf(ARR, ARR.length);
    insertionSort.sort(arr, arr.length);
    assertArrayEquals(SORTED_ARR, arr);
  }

  @Test
  void mergeSort() {
    MergeSort mergeSort = new MergeSort();
    int[] arr = Arrays.copyOf(ARR, ARR.length);
    mergeSort.sort(arr, arr.length);
    assertArrayEquals(SORTED_ARR, arr);
  }

  @Test
  void quickSort() {
    QuickSort quickSort = new QuickSort();
    int[] arr = Arrays.copyOf(ARR, ARR.length);
    quickSort.sort(arr, arr.length);
    assertArrayEquals(SORTED_ARR, arr);
  }

  @Test
  void countingSort() {
    CountingSort countingSort = new CountingSort();
    int[] arr = Arrays.copyOf(ARR, ARR.length);
    countingSort.sort(arr, arr.length);
    assertArrayEquals(SORTED_ARR, arr);
  }
}