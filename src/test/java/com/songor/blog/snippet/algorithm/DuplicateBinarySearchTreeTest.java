package com.songor.blog.snippet.algorithm;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DuplicateBinarySearchTreeTest {
  private DuplicateBinarySearchTree tree;

  @BeforeEach
  void init() {
    tree = new DuplicateBinarySearchTree();
    tree.insert(13);
    tree.insert(8);
    tree.insert(18);
    tree.insert(6);
    tree.insert(10);
    tree.insert(16);
    tree.insert(20);
  }

  @Test
  void duplicateFind() {
    tree.duplicateInsert(18);
    assertEquals(2, tree.duplicateFind(18).size());
  }

  @Test
  void duplicateInsert() {
    tree.duplicateInsert(18);
    List<Integer> excepted = Arrays
        .asList(6, 8, 10, 13, 16, 18, 18, 20);
    Node<Integer> node = tree.getTree();
    BinaryTreeTraverse traverse = new InOrderBinaryTreeTraverse();
    List<Integer> actual = traverse.traverse(node);
    assertArrayEquals(excepted.toArray(), actual.toArray());
  }

  @Test
  void duplicateDelete() {
    tree.duplicateInsert(18);
    tree.duplicateInsert(19);
    tree.duplicateDelete(18);

    List<Integer> excepted = Arrays
        .asList(6, 8, 10, 13, 16, 19, 20);
    Node<Integer> node = tree.getTree();
    BinaryTreeTraverse traverse = new InOrderBinaryTreeTraverse();
    List<Integer> actual = traverse.traverse(node);
    assertArrayEquals(excepted.toArray(), actual.toArray());
  }
}