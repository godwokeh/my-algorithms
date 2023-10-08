import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        BufferedReader in = null;
        StringBuilder s = new StringBuilder();
        int arrsize = 0;
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            arrsize = Integer.parseInt(in.readLine());
            int[] nums = new int[arrsize];
            String numbers = in.readLine() + " ";
            int j = 0;
            for (int i = 0; i < numbers.length(); i++) {
                if (Character.isDigit(numbers.charAt(i))) {
                    s.append(numbers.charAt(i));
                } else {
                    nums[j] = Integer.parseInt(s.toString());
                    j++;
                    s.setLength(0);
                }
            }
            int l = 0;
            int r = nums.length - 1;
            quickSort(nums, l, r);
            for (int i = 0; i < nums.length; i++) {
                System.out.print(nums[i] + " ");
            }
            in.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
    public static void quickSort(int[] arr, int l, int r) {
        if (r - l <= 32) {
            insertionSort(arr, l, r);
            return;
        }
        int med = nineMedian(arr, l, r);
        swap(l, med, arr);
        int pivot = partition(arr, l, r);
        quickSort(arr, l, pivot - 1);
        quickSort(arr, pivot + 1, r);
    }
    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static int partition(int[] arr, int l, int r) {
        int pivot = arr[r];
        int pointer = l - 1;
        for (int i = l; i < r; i++) {
            if (arr[i] < pivot) {
                pointer++;
                swap(pointer, i, arr);
            }
        }
        swap(pointer + 1, r, arr);
        return pointer + 1;
    }

    private static void swap(int pointer, int i, int[] arr) {
        int temp = arr[pointer];
        arr[pointer] = arr[i];
        arr[i] = temp;
    }
    private static int median(int[] arr, int l, int m, int r) {
        if (arr[l] <= arr[m]) {
            if (arr[m] <= arr[r]) {
                return m;
            }
        } else {
            if (arr[l] <= arr[r]) {
                return l;
            }
        }
        return r;
    }
    private static void insertionSort(int[] arr, int l, int r) {
        for (int i = l; i <= r; i++) {
            int pasteElement = arr[i];
            int j;
            for (j = i; j > l; j--) {
                if (arr[j - 1] <= pasteElement) {
                    break;
                }
                arr[j] = arr[j-1];
            }
            arr[j] = pasteElement;
        }
    }

    private static int nineMedian(int[] arr, int l, int r) {
        int part = (r - l) / 3;
        int medianA = median(arr, l, l + part / 2, l + part);
        int medianB = median(arr, l + part + 1, l + 3 * part / 2 + 1, l + 2 * part);
        int medianC = median(arr, l + 2 * part + 1, l + 5 * part / 2 + 1, r);
        return median(arr, medianA, medianB, medianC);
    }
}