package com.songor.blog.snippet.algorithm;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BinarySearchFindFirstGreaterOrEqualTest {
  @Test
  void search() {
    int[] arr = {1, 3, 4, 5, 6, 8, 8, 8, 11, 18};
    BinarySearchFindFirstGreaterOrEqual binarySearch = new BinarySearchFindFirstGreaterOrEqual();
    assertEquals(5, binarySearch.search(arr, arr.length, 8));
    assertEquals(8, binarySearch.search(arr, arr.length, 10));
  }
}