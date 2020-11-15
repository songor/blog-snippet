package com.songor.blog.snippet.algorithm;

import java.util.Objects;

/**
 * 基于链表实现 LRU 缓存淘汰算法
 * 我们维护一个有序单链表，越靠近链表尾部的节点是越早之前访问的。
 * 当有一个新的数据被访问时，我们从链表头开始顺序遍历链表。
 * 如果此数据之前已经被缓存在链表中了，我们遍历得到这个数据对应的节点，并将其从原来的位置删除，然后再插入到链表的头部。
 * 如果此数据没有在缓存链表中，又可以分为两种情况：
 * 如果此时缓存未满，则将此节点直接插入到链表的头部。
 * 如果此时缓存已满，则删除链表尾节点，将新的数据节点插入链表的头部。
 *
 * @param <T> 元素类型
 * @author chensongyu
 */
public class LRULinkedList<T> {

  private static final int DEFAULT_CAPACITY = 15;

  private final Node<T> head = new Node<>(null, null);

  private int capacity = DEFAULT_CAPACITY;

  private int size = 0;

  public LRULinkedList() {
  }

  public LRULinkedList(int capacity) {
    this.capacity = capacity;
  }

  public void add(T element) {
    if (Objects.isNull(element)) {
      throw new IllegalArgumentException("element should not be null");
    }

    Node<T> previous = findPrevious(element);
    if (previous != null) {
      exchangeToHead(previous);
    } else {
      insertToHead(element);
      if (size > capacity) {
        deleteLast();
      }
    }
  }

  public void print() {
    Node<T> node = head.next;
    while (node != null) {
      System.out.println(node.data);
      node = node.next;
    }
  }

  private Node<T> findPrevious(T element) {
    Node<T> previous = head;
    Node<T> current = head.next;
    while (current != null) {
      if (Objects.equals(current.data, element)) {
        return previous;
      } else {
        current = current.next;
        previous = previous.next;
      }
    }
    return null;
  }

  private void exchangeToHead(Node<T> previous) {
    Node<T> current = previous.next;
    previous.next = current.next;
    current.next = head.next;
    head.next = current;
  }

  private void insertToHead(T element) {
    Node<T> node = new Node<>();
    node.data = element;
    node.next = head.next;
    head.next = node;
    size++;
  }

  private void deleteLast() {
    Node<T> previous = head;
    Node<T> last = head.next;
    while (last.next != null) {
      previous = previous.next;
      last = last.next;
    }
    previous.next = null;
    size--;
  }

  private static class Node<T> {

    T data;
    Node<T> next;

    Node() {
    }

    Node(T data, Node<T> next) {
      this.data = data;
      this.next = next;
    }
  }
}
