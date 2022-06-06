package ds;

public class BinaryTree {
  public int countLevel(Node root) {
    if (root == null)
      return 0;

    return 1 + Math.max(countLevel(root.getLeft()), countLevel(root.getRight()));
  }
}
