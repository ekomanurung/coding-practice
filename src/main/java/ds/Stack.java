package ds;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class Stack {
  static final int DEFAULT_CAPACITY = 5;
  private Integer[] elements;
  private AtomicInteger size = new AtomicInteger();

  public Stack() {
    this.elements = new Integer[DEFAULT_CAPACITY];
  }

  public void setElements(Integer[] el) {
    this.elements = el;
  }

  public void add(int e) {
    ensureCapacity();
    this.elements[this.size.getAndIncrement()] = e;
  }

  private void ensureCapacity() {
    if (this.elements.length - 1 == this.size.get()) {
      this.setElements(Arrays.copyOf(this.elements, this.elements.length + DEFAULT_CAPACITY));
    }
  }

  public int pop() {
    int idx = this.getSize()-1;
    int el = this.elements[idx];

    this.elements[idx] = null;
    this.size.decrementAndGet();

    return el;
  }

  public int getSize() {
    return this.size.get();
  }

  public boolean isEmpty() {
    return getSize() == 0;
  }
}
