package ds;

public class BinaryTree {
  public int countLevel(Node root) {
    if (root == null)
      return 0;

    return 1 + Math.max(countLevel(root.getLeft()), countLevel(root.getRight()));
  }

  public int findLevelOf(Node root, int target, int level) {
    if (root == null) {
      return -1;
    }

    if (root.getData() == target)
      return level;

    return Math.max(findLevelOf(root.getRight(), target, level + 1),
        findLevelOf(root.getLeft(), target, level + 1));
  }
}
