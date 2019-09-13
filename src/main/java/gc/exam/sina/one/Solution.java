package gc.exam.sina.one;

import java.util.Arrays;

/**
 * @author gengchao
 * @date 2019/8/31 15:40
 * @description：
 */
class Solution {
    public int minIncrementForUnique(int[] arr) {
        int n = arr.length;
        if (n <= 1) return 0;
        Arrays.sort(arr);
        int res = 0;
        for (int i = 1; i < n; i++) {
            while (arr[i] <= arr[i - 1] ) {
                arr[i] += 1;
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minIncrementForUnique(new int[]{3, 2, 1, 2, 1, 7}));
    }
}