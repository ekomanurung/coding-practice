package paypay;

public class CountWords {
  public static void main(String[] args) {
//    System.out.println("hit", "cog", new String[]{"hot", "dot", "dog"});
  }

  static int solution(String begin, String end, String[] wordList) {
    int result = 0;

    for (int i = 0; i < wordList.length; i++) {
      int count = 0;
      for (int j = 0; j < begin.length(); j++) {
        if (begin.charAt(j) == wordList[i].charAt(j)) {
          count++;
        }
        if (count == 1) {
          result++;
          begin = wordList[i];
        }
      }
    }
    return result;
  }
}
