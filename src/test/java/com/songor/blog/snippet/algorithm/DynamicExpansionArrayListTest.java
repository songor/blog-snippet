package com.songor.blog.snippet.algorithm;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class DynamicExpansionArrayListTest {
  @Test
  void shouldAddElementSuccess() {
    String[] elements = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");

    DynamicExpansionArrayList<String> list = new DynamicExpansionArrayList<>(5);
    Arrays.stream(elements).forEach(list::add);

    assertEquals(26, list.size());
    assertEquals("J", list.get(9));
    assertArrayEquals(elements, list.toArray());
  }
}