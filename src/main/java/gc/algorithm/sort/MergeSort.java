package gc.algorithm.sort;

import java.util.Arrays;

public class MergeSort {


    public static void main(String[] args) {
        int[] arr = {2,3,2,3,-12,3,324,5,23,4,12,4,34};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] nums){
        int[] temp = new int[nums.length];
        sort(nums,0,nums.length-1,temp);
    }

    public static void sort(int[] nums,int start, int end,int[] temp){
        if(start>=end)
            return;;
        int mid = (end-start)/2+start;

        sort(nums,start,mid,temp);
        sort(nums,mid+1,end,temp);
        merge(nums,start,mid,end,temp);
    }

    public static void merge(int[] nums,int start,int mid,int end,int[] temp){
        if(start>=end)
            return;
        int i = start;
        int j = mid+1;
        int k = start;
        while(i<=mid && j<=end){
            if(nums[i]<=nums[j])
                temp[k++] = nums[i++];
            else
                temp[k++] = nums[j++];
        }
        while(i<=mid)
            temp[k++] = nums[i++];
        while(j<=end)
            temp[k++] = nums[j++];
        for(int idx=start; idx<=end; idx++)
            nums[idx] = temp[idx];
    }

}
