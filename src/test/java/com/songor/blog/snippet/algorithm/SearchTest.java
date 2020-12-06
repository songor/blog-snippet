package com.songor.blog.snippet.algorithm;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SearchTest {
  private final int[] SORTED_ARR = {8, 11, 19, 23, 27, 33, 45, 55, 67, 98};

  @Test
  void binarySearch() {
    int value = 23;
    BinarySearch binarySearch = new BinarySearch();
    assertEquals(3, binarySearch.search(SORTED_ARR, SORTED_ARR.length, value));
  }

  @Test
  void binarySearchUseRecursion() {
    int value = 23;
    BinarySearchUseRecursion binarySearch = new BinarySearchUseRecursion();
    assertEquals(3, binarySearch.search(SORTED_ARR, SORTED_ARR.length, value));
  }
}