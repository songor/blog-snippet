package com.songor.blog.snippet.algorithm;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BinarySearchFindLastTest {

  @Test
  void search() {
    int[] arr = {1, 3, 4, 5, 6, 8, 8, 8, 11, 18};
    BinarySearchFindLast binarySearch = new BinarySearchFindLast();
    assertEquals(7, binarySearch.search(arr, arr.length, 8));
  }
}