package com.songor.blog.snippet.algorithm;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class BinaryTreeTraverseTest {
  private static Node<String> node;

  @BeforeAll
  static void init() {
    Node<String> dNode = new Node<>();
    dNode.setData("D");
    Node<String> eNode = new Node<>();
    eNode.setData("E");
    Node<String> fNode = new Node<>();
    fNode.setData("F");
    Node<String> gNode = new Node<>();
    gNode.setData("G");
    Node<String> bNode = new Node<>();
    bNode.setData("B");
    bNode.setLeft(dNode);
    bNode.setRight(eNode);
    Node<String> cNode = new Node<>();
    cNode.setData("C");
    cNode.setLeft(fNode);
    cNode.setRight(gNode);
    node = new Node<>();
    node.setData("A");
    node.setLeft(bNode);
    node.setRight(cNode);
  }

  @Test
  void preOrder() {
    List<String> excepted = Arrays.asList("A", "B", "D", "E", "C", "F", "G");
    BinaryTreeTraverse traverse = new PreOrderBinaryTreeTraverse();
    List<String> actual = traverse.traverse(node);
    assertArrayEquals(excepted.toArray(), actual.toArray());
  }

  @Test
  void inOrder() {
    List<String> excepted = Arrays.asList("D", "B", "E", "A", "F", "C", "G");
    BinaryTreeTraverse traverse = new InOrderBinaryTreeTraverse();
    List<String> actual = traverse.traverse(node);
    assertArrayEquals(excepted.toArray(), actual.toArray());
  }

  @Test
  void postOrder() {
    List<String> excepted = Arrays.asList("D", "E", "B", "F", "G", "C", "A");
    BinaryTreeTraverse traverse = new PostOrderBinaryTreeTraverse();
    List<String> actual = traverse.traverse(node);
    assertArrayEquals(excepted.toArray(), actual.toArray());
  }
}