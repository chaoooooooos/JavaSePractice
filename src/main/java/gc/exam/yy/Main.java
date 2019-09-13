package gc.exam.yy;

import java.util.Scanner;

/**
 * @author gengchao
 * @date 2019/9/9 19:02
 * @description：
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int[] arr = string2arr(s, ",");
        helper(arr);
        for (int i = 0; i < arr.length; i++)
            if (i != arr.length - 1)
                System.out.print(arr[i] + ",");
            else
                System.out.print(arr[i]);

    }

    public static int[] string2arr(String s, String separator) {
        String[] ss = s.split(separator);
        int[] arr = new int[ss.length];
        for (int i = 0; i < ss.length; i++) {
            arr[i] = Integer.valueOf(ss[i]);
        }
        return arr;
    }

    public static void helper(int[] nums) {
        int n = nums.length;
        if (n <= 1) return;
        int idx = n - 1;
        while (idx > 0 && nums[idx] <= nums[idx - 1])
            idx--;
        if (idx == 0)
            reverse(nums, 0, n - 1);
        else {
            int base = idx - 1;
            for (int i = n - 1; i >= 0; i--)
                if (nums[i] > nums[base]) {
                    swap(nums, base, i);
                    break;
                }
            reverse(nums, base + 1, n - 1);
        }
    }


    static void reverse(int[] arr, int i, int j) {
        while (i < j) {
            swap(arr, i++, j--);
        }
    }

    static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}