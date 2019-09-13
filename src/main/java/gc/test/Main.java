package gc.test;

import java.util.*;


public class Main {
    static volatile int m = 0;
    public static void main(String[] args) throws InterruptedException {
        System.out.println(trap(new int[]{0,0,5}));
    }

    static int cnt = 0;
    public static int trap(int[] arr) {
        if(arr==null || arr.length<=2)
            return 0;
        int n = arr.length;
        for(int num : arr)
            if(num>0)
                cnt++;
        // System.out.println("cnt->"+cnt);
        int res = 0;
        while(cnt>=2){
            res += helper(arr);
        }
        return res;

    }

    public static int helper(int[] arr){
        int left = 0;
        int right = arr.length-1;
        int res = 0;
        while(arr[left]<=0)
            left++;
        while(arr[right]<=0)
            right--;
        while(left<=right){
            if(arr[left]<=0)
                res++;
            if(arr[left]==1)
                cnt--;
            arr[left]--;
            left++;
        }
        // System.out.println("cnt->"+cnt);
        // System.out.println("arr->"+Arrays.toString(arr));
        return res;
    }
}



