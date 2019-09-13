package gc.leetcode;

import java.lang.reflect.Array;
import java.util.*;

public class Solution {
    private Integer last = null;

    public boolean VerifySquenceOfBST(int[] arr) {
        int n = arr.length;
        if (n == 0) return false;
        if (n == 1) return true;
        return helper(arr, 0, n - 1);

    }

    public boolean helper(int[] arr, int start, int end) {
        if (start >= end) return true;
        int mid = arr[end];
        int left = start;
        while (arr[left] < mid)
            left++;
        for (int i = left; i < end; i++) {
            if (arr[i] < arr[end])
                return false;
        }
        return helper(arr, start, left - 1) && helper(arr, left, end);

    }
}











