package io.github.bw;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class ByteExampleTest {

  @Test
  void byteTest() {
    long abc = 9999999999L;
    System.out.println(abc + "\t byte:" + Long.toBinaryString(abc));
    System.out.println("~15\t byte:" + Long.toBinaryString(~15));
    long hh = ((abc & ~15) + 16);
    System.out.println(hh + "\t byte:" + Long.toBinaryString(hh));
  }

  @Test
  void setTest() {
    Set<Node> dataset = new HashSet<>();

    String firstNull = dataset.stream().map(Node::getName).findFirst().orElse(null);
    Assertions.assertNull(firstNull);

    dataset.add(new Node("a"));

    String firstNode = dataset.stream().map(Node::getName).findFirst().orElse(null);
    Assertions.assertEquals(firstNode, "a");
  }

  class Node {

    private String name;

    public Node(String name) {
      this.name = name;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }
  }


}