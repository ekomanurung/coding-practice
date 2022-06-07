package ds;

import org.junit.Assert;
import org.junit.Test;

public class BinaryTreeTest {

  @Test
  public void testCountLevel_NullTree() {
    BinaryTree bt = new BinaryTree();
    Assert.assertEquals(0, bt.countLevel(null));
  }

  @Test
  public void testCountLevel_OnlyRootTree() {
    BinaryTree bt = new BinaryTree();
    Assert.assertEquals(1, bt.countLevel(new Node(1)));
  }

  @Test
  public void testCountLevel_2Level() {
    BinaryTree bt = new BinaryTree();
    Node root = new Node(1);
    root.setLeft(new Node(2));
    root.setRight(new Node(3));

    Assert.assertEquals(2, bt.countLevel(root));
  }

  @Test
  public void testCountLevel_3Level() {
    BinaryTree bt = new BinaryTree();
    Node root = new Node(1);
    root.setLeft(new Node(2));
    root.getLeft().setLeft(new Node(4));
    root.getLeft().setRight(new Node(5));
    root.setRight(new Node(3));
    root.getRight().setLeft(new Node(6));
    root.getRight().setRight(new Node(7));

    Assert.assertEquals(3, bt.countLevel(root));
  }

  @Test
  public void testCountLevel_4Level() {
    BinaryTree bt = new BinaryTree();
    Node root = new Node(1);
    root.setLeft(new Node(2));
    root.getLeft().setLeft(new Node(4));
    root.getLeft().setRight(new Node(5));
    root.getLeft().getLeft().setLeft(new Node(6));
    root.getLeft().getLeft().setRight(new Node(7));
    root.setRight(new Node(3));

    Assert.assertEquals(4, bt.countLevel(root));
  }

  @Test
  public void findLevelOf_EmptyTree() {
    BinaryTree bt = new BinaryTree();

    Assert.assertEquals(-1, bt.findLevelOf(null, 2, 0));
  }

  @Test
  public void findLevelOf_OnlyRootTree() {
    BinaryTree bt = new BinaryTree();
    Node root = new Node(3);

    Assert.assertEquals(0, bt.findLevelOf(root, 3, 0));
  }

  @Test
  public void findLevelOf_TreeComplete() {
    BinaryTree bt = new BinaryTree();
    Node root = new Node(1);
    root.setLeft(new Node(2));
    root.getLeft().setLeft(new Node(4));
    root.getLeft().setRight(new Node(5));
    root.getLeft().getLeft().setLeft(new Node(6));
    root.getLeft().getLeft().setRight(new Node(7));
    root.setRight(new Node(3));

    Assert.assertEquals(1, bt.findLevelOf(root, 3, 0));
  }
}
