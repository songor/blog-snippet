package com.songor.blog.snippet.algorithm;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BubbleSortTest {
  private BubbleSort bubbleSort = new BubbleSort();

  @Test
  void sort() {
    int[] arr = {3, 5, 4, 2, 6, 1};
    bubbleSort.sort(arr, arr.length);
    assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, arr);

    int[] sortedArr = {1, 2, 3, 4, 5, 6};
    bubbleSort.sort(sortedArr, sortedArr.length);
    assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, sortedArr);
  }
}