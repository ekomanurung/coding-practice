package concurrency;

/**
 * problem is to print odd and even number using 2 thread
 */
public class ThreadInterleave {
  private int counter;
  private int max;

  public ThreadInterleave(int counter, int max) {
    this.counter = counter;
    this.max = max;
  }

  public static void main(String[] args) {
    ThreadInterleave ti = new ThreadInterleave(1, 10);

    Thread t1 = new Thread(ti::printOddNumber, "thread-1");
    Thread t2 = new Thread(ti::printEvenNumber, "thread-2");

    t2.start();
    t1.start();
  }

  private void printOddNumber() {
    synchronized (this) {
      while (counter <= max) {
        while (counter % 2 == 0) {
          try {
            wait();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
        if (counter > max) {
          break;
        }
        System.out.println(counter + ":\t " + Thread.currentThread().getName());
        counter++;
        notify();
      }
    }
  }

  private void printEvenNumber() {
    synchronized (this) {
      while (counter <= max) {
        while (counter % 2 == 1) {
          try {
            wait();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
        if (counter > max) {
          break;
        }

        System.out.println(counter + ":\t " + Thread.currentThread().getName());
        counter++;
        notify();
      }
    }
  }
}
