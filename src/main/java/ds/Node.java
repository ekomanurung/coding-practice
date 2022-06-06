package ds;


public class Node {
  private Node right;
  private Node left;
  private int data;

  public Node(int data) {
    this.data = data;
  }

  public Node getRight() {
    return right;
  }

  public void setRight(Node right) {
    this.right = right;
  }

  public Node getLeft() {
    return left;
  }

  public void setLeft(Node left) {
    this.left = left;
  }

  public int getData() {
    return data;
  }

  public void setData(int data) {
    this.data = data;
  }
}