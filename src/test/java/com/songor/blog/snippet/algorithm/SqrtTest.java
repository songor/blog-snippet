package com.songor.blog.snippet.algorithm;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SqrtTest {
  @Test
  void sqrt() {
    Sqrt sqrt = new Sqrt();
    int value = 5;
    double threshold = 1e-6;
    double actual = sqrt.sqrt(value, threshold);
    assertTrue(Math.abs(actual * actual - value) <= threshold);
  }
}