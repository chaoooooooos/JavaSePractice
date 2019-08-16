package gc.algorithm.sort;

import java.util.Arrays;

public class BubbleSort {
    public static void sort(int[] nums){
        int t = -1;
        int lastExchangeIdx = 0;
        int sortBorder = nums.length-1;
        for(int i=0;i<nums.length-1;i++){  //交换的轮数，比数组长度少1
            boolean f = true;
            for(int j=0;j<sortBorder;j++) {
                if (nums[j]>nums[j+1]){
                    t = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = t;
                    f = false;
                    lastExchangeIdx = j;
                }
            }
            if(f)
                break;
            sortBorder = lastExchangeIdx;
        }
    }
    public static void main(String[] args) {
        int[] arr = {0,3,43,-3,4,1,-4,2,4};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
