import java.util.Arrays;

public class MergeSortTrain {
    public static void main(String[] args) {
        int[] arr1 = new int[] {5, 6, 7, 1, 2, 3, 9, 8, 4, 10, 19, 17, 11, 13, 12, 16, 14, 18, 15, 20};
        //int[] arr3 = new int[] {1, 2, 3};
        //int[] arr4 = new int[] {4, 5, 6};
        int[] arr2 = sortMerge(arr1);System.out.println(Arrays.toString(arr1));
        System.out.println();
        System.out.println(Arrays.toString(arr2));
        //int[] mergedarr = merge(arr3, arr4);
       //System.out.println(Arrays.toString(mergedarr));

    }
    public static int[] sortMerge(int[] arr) {
        if (arr == null) {
            System.err.println("Array is null");
            return null;
        }
        if (arr.length < 2) {
            return arr;
        }
        int[] left = new int[arr.length / 2];
        int[] right = new int[arr.length - (arr.length / 2)];
        System.arraycopy(arr, 0, left, 0, arr.length / 2);
        System.arraycopy(arr, arr.length / 2, right, 0, arr.length - (arr.length / 2));
        left = sortMerge(left);
        right = sortMerge(right);
        return merge(left, right);
    }
    private static int[] merge(int[] a, int[] b) {
        int j = 0;
        int i = 0;
        int k = 0;
        int n = a.length;
        int m = b.length;
        int[] c = new int[m + n];
        while (i < n && j < m) {
            if (a[i] < b[j]) {
                c[k] = a[i];
                i++;
            } else {
                c[k] = b[j];
                j++;
            }
            k++;
        }
        while (i < n) {
            c[k] = a[i];
            i++;
            k++;
        }
        while (j < m) {
            c[k] = b[j];
            j++;
            k++;
        }
        return c;
    }
}
