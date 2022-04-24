package shopee;

class MergeSort {

  void mergeSort(int[] array, int left, int right) {
    if (left < right) {
      int mid = left + (right - left) / 2;

      mergeSort(array, left, mid);
      mergeSort(array, mid + 1, right);
      merge(array, left, mid, right);
    }
  }

  void merge(int[] arr, int left, int mid, int right) {
    //create 2 temp array based on size left and right arr
    int leftSize = mid - left + 1;
    int rightSize = right - mid;

    int[] leftArr = new int[leftSize];
    int[] rightArr = new int[rightSize];

    for (int i = 0; i < leftSize; i++)
      leftArr[i] = arr[left + i];
    for (int j = 0; j < rightSize; j++) {
      rightArr[j] = arr[mid + 1 + j];
    }

    int i = 0, j = 0, k = left;

    while (i < leftSize && j < rightSize) {
      if (leftArr[i] >= rightArr[j]) {
        arr[k] = leftArr[i];
        i++;
      } else {
        arr[k] = rightArr[j];
        j++;
      }
      k++;
    }

    while (i < leftSize) {
      arr[k] = leftArr[i];
      k++;
      i++;
    }
    while (j < rightSize) {
      arr[k] = rightArr[j];
      k++;
      j++;
    }
  }

  void print(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + ", ");
    }
  }
}


public class FindKthLargestElement {
  //  Find k-th largest element
  public static void main(String[] args) {
    int[] arr = new int[] {7, 1, 4, 3, 2, 8};
    System.out.println(findKthLargestElement(arr, 7));
  }

  static int findKthLargestElement(int[] array, int k) {
    if (k < 1 || k > array.length)
      return -1;
    //sort first
    MergeSort mergeSort = new MergeSort();
    //using length
    mergeSort.mergeSort(array, 0, array.length - 1);
    return array[k - 1];
  }
}
