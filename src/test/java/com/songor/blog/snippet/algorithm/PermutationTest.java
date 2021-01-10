package com.songor.blog.snippet.algorithm;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class PermutationTest {

  @Test
  void print() {
    List<String> actual = new ArrayList<>();
    int[] data = {1, 2, 3};
    Permutation permutation = new Permutation();
    permutation.print(data, data.length, data.length, actual);

    List<String> excepted = Arrays.asList("1,2,3", "1,3,2", "2,1,3", "2,3,1", "3,1,2", "3,2,1");
    assertTrue(excepted.size() == actual.size() && excepted.containsAll(actual) && actual
        .containsAll(excepted));
  }
}