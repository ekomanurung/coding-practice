package hackerrank;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinaryMultiplicationTest {

  @Test
  public void testBinaryMultiplication() {
    BinaryMultiplication bm = new BinaryMultiplication();
    assertEquals(3, bm.solution(3, 7));
    assertEquals(0, bm.solution(5, 0));
    assertEquals(0, bm.solution(100000000, 0));
    assertEquals(12, bm.solution(100000000, 1));
    assertEquals(11, bm.solution(100000, 100000));
    assertEquals(13, bm.solution(1000000, 1000000));
    assertEquals(17, bm.solution(10000000, 10000000));
    assertEquals(20, bm.solution(100000000, 100000000));
  }
}
