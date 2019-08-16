package gc.algorithm;

import gc.algorithm.sort.MergeSort;
import gc.algorithm.sort.QuickSort;

import java.util.Arrays;
import java.util.Random;

public class SortTest {
    public static void main(String[] args) {
        int N = 100000000;
        int[] nums = new int[N];
        Random random = new Random();
        for (int i = 0; i < N; i++)
            nums[i] = random.nextInt(2 * N);

        int[] arr1 = Arrays.copyOf(nums, N);
        int[] arr2 = Arrays.copyOf(nums, N);

        long start = System.currentTimeMillis();
        QuickSort.quickSort(arr1);
        long end = System.currentTimeMillis();
        System.out.println("快排时间" + (end - start) + "ms");
        arr1 = null;


        long s = System.currentTimeMillis();
        MergeSort.mergeSort(arr2);
        long e = System.currentTimeMillis();
        System.out.println("归并时间" + (e - s) + "ms");
        arr2 = null;


        long s1 = System.currentTimeMillis();
        Arrays.sort(nums);
        long e1 = System.currentTimeMillis();
        System.out.println("Arrays.sort时间" + (e1 - s1) + "ms");
    }

}
