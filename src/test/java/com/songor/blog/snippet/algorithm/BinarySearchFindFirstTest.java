package com.songor.blog.snippet.algorithm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class BinarySearchFindFirstTest {
  @Test
  void search() {
    int[] arr = {1, 3, 4, 5, 6, 8, 8, 8, 11, 18};
    BinarySearchFindFirst binarySearch = new BinarySearchFindFirst();
    assertEquals(5, binarySearch.search(arr, arr.length, 8));
  }
}