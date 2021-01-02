package com.songor.blog.snippet.algorithm;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BinarySearchTreeTest {
  @Test
  void insert() {
    BinarySearchTree tree = new BinarySearchTree();
    tree.insert(33);
    tree.insert(16);
    tree.insert(50);
    tree.insert(13);
    tree.insert(18);
    tree.insert(34);
    tree.insert(58);
    tree.insert(15);
    tree.insert(17);
    tree.insert(25);
    tree.insert(51);
    tree.insert(66);
    tree.insert(19);
    tree.insert(27);
    tree.insert(55);

    List<Integer> excepted = Arrays
        .asList(13, 15, 16, 17, 18, 19, 25, 27, 33, 34, 50, 51, 55, 58, 66);
    Node<Integer> node = tree.getTree();
    BinaryTreeTraverse traverse = new InOrderBinaryTreeTraverse();
    List<Integer> actual = traverse.traverse(node);
    assertArrayEquals(excepted.toArray(), actual.toArray());
  }

  @Test
  void find() {
    BinarySearchTree tree = new BinarySearchTree();
    tree.insert(33);
    tree.insert(16);
    tree.insert(50);
    tree.insert(13);
    tree.insert(18);
    tree.insert(34);
    tree.insert(58);
    tree.insert(15);
    tree.insert(17);
    tree.insert(25);
    tree.insert(51);
    tree.insert(66);
    tree.insert(19);
    tree.insert(27);
    tree.insert(55);

    assertNotNull(tree.find(33));
    assertNull(tree.find(-1));
  }

  @Test
  void delete() {
    BinarySearchTree tree = new BinarySearchTree();
    tree.insert(33);
    tree.insert(16);
    tree.insert(50);
    tree.insert(13);
    tree.insert(18);
    tree.insert(34);
    tree.insert(58);
    tree.insert(15);
    tree.insert(17);
    tree.insert(25);
    tree.insert(51);
    tree.insert(66);
    tree.insert(19);
    tree.insert(27);
    tree.insert(55);

    tree.delete(13);
    tree.delete(18);
    tree.delete(55);

    List<Integer> excepted = Arrays
        .asList( 15, 16, 17, 19, 25, 27, 33, 34, 50, 51, 58, 66);
    Node<Integer> node = tree.getTree();
    BinaryTreeTraverse traverse = new InOrderBinaryTreeTraverse();
    List<Integer> actual = traverse.traverse(node);
    assertArrayEquals(excepted.toArray(), actual.toArray());
  }
}