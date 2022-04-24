package ds;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

public class StackTest {

  @Test
  public void initializeStackEmptyWithDefaultCapacity() {
    Stack stack = new Stack();
    assertTrue(stack.isEmpty());
    assertEquals(0, stack.getSize());
  }

  @Test
  public void addElementToStack() {
    Stack stack = new Stack();
    stack.add(1);
    stack.add(2);
    stack.add(3);

    assertFalse(stack.isEmpty());
    assertEquals(3, stack.getSize());
  }

  @Test
  public void addElementToStackIncreaseCapacity() {
    Stack stack = new Stack();
    stack.add(1);
    stack.add(2);
    stack.add(3);
    stack.add(4);
    stack.add(5);
    stack.add(6);

    assertFalse(stack.isEmpty());
    assertEquals(6, stack.getSize());
  }

  @Test
  public void popElement() {
    Stack stack = new Stack();
    stack.add(1);
    stack.add(2);
    stack.add(3);
    stack.add(4);
    assertFalse(stack.isEmpty());
    assertEquals(4, stack.getSize());

    int res = stack.pop();
    assertEquals(4, res);
    assertEquals(3, stack.getSize());
    assertFalse(stack.isEmpty());
  }

  @Test
  public void popEmptyStack() {
    Stack stack = new Stack();
    assertThrows("Stack is empty, can't pop", Exception.class, stack::pop);
    assertEquals(0, stack.getSize());
    assertTrue(stack.isEmpty());
  }
}
