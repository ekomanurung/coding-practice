package agoda;

/*

Problem: An encoded string (s) is given, the task is to decode it. The pattern in which the strings are encoded is as follows.

<count>[sub_str] ==> The substring 'sub_str'
                      appears count times.
Examples:

Input : str[] = "1[b]"
Output : b

Input : str[] = "2[ab]"
Output : abab

Input : str[] = "2[a2[b]]"
Output : abbabb

Input : str[] = "3[b2[ca]]"
Output : bcacabcacabcaca
*/

import java.util.Stack;

public class TaskB {
  public static void main(String[] args) {
    System.out.println(decodeV2("1[b]"));
    System.out.println(decodeV2("2[ab]"));
    System.out.println(decodeV2("ac2[b]"));
    System.out.println(decodeV2("2[a2[b]]"));
    System.out.println(decodeV2("3[b2[ca]]"));
  }

  static String decodeV2(String input) {
    Stack<Character> stack = new Stack<>();

    String ans = "";

    int l = input.length();
    int i = 0;
    do {
      if (i < l && input.charAt(i) != ']') {
        stack.push(input.charAt(i));
      } else {
        StringBuilder tempSolution = new StringBuilder();
        String tempChar = "" + ans;
        while (true) {
          if (stack.isEmpty()) {
            break;
          } else if (stack.peek() == '[') {
            stack.pop();
            break;
          } else {
            tempChar += stack.peek();
            stack.pop();
          }
        }

        int iterator = 1;
        try {
          iterator = Integer.parseInt(Character.toString(stack.peek()));
          stack.pop();
        } catch (Exception e) {
          //continue to process if it is a char
        }
        for (int j = 0; j < iterator; j++) {
          tempSolution.append(tempChar);
        }
        ans = tempSolution.toString();
      }
      i++;
    } while (!stack.isEmpty());

    return reverse(ans);
  }

  static String reverse(String begin) {
    StringBuilder solution = new StringBuilder();
    for (int j = begin.length() - 1; j >= 0; j--) {
      solution.append(begin.charAt(j));
    }

    return solution.toString();
  }
}
