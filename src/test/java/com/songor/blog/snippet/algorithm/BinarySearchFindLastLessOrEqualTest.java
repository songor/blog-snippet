package com.songor.blog.snippet.algorithm;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BinarySearchFindLastLessOrEqualTest {
  @Test
  void search() {
    int[] arr = {1, 3, 4, 5, 6, 8, 8, 8, 11, 18};
    BinarySearchFindLastLessOrEqual binarySearch = new BinarySearchFindLastLessOrEqual();
    assertEquals(4, binarySearch.search(arr, arr.length, 7));
    assertEquals(7, binarySearch.search(arr, arr.length, 8));
  }
}