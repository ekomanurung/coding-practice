package shopee;

public class MergeSortedArrays {
  public static void main(String[] args) {
    int[] array1 = new int[] {4, 6, 8, 10};
    int[] array2 = new int[] {1, 3, 5, 7, 9};

    print(mergeSortedArrays(array1, array2));
  }

  static void print(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + ",");
    }
  }

  static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
    int N = arr1.length;
    int M = arr2.length;

    int[] solutions = new int[N + M];
    int i = 0, j = 0, k = 0;
    while (i < N && j < M) {
      if (arr1[i] <= arr2[j]) {
        solutions[k] = arr1[i];
        i++;
      } else {
        solutions[k] = arr2[j];
        j++;
      }
      k++;
    }

    while (i < N) {
      solutions[k] = arr1[i];
      i++;
      k++;
    }

    while (j < M) {
      solutions[k] = arr2[j];
      j++;
      k++;
    }
    return solutions;
  }
}
