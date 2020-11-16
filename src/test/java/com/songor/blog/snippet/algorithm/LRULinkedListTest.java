package com.songor.blog.snippet.algorithm;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class LRULinkedListTest {
  @Test
  void shouldGetElementsSuccessWhen() {
    String str = "3141592653589793";
    String[] elements = str.split("");

    LRULinkedList<String> list = new LRULinkedList<>(5);
    Arrays.stream(elements).forEach(list::add);

    String[] expected = {"3", "9", "7", "8", "5"};
    String[] actual = list.get().toArray(new String[0]);
    assertArrayEquals(expected, actual);
  }
}