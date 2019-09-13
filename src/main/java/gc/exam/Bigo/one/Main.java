package gc.exam.Bigo.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author gengchao
 * @date 2019/9/8 15:01
 * @description：
 */
public class Main {
    public static void main(String[] args) {
       int[] arr = {1,2};
       swap(arr,0,1);
        System.out.println("a[0]="+arr[0]+",a[1]="+arr[1]);

    }

    static void swap(int[] arr,int i,int j){
        arr[i] ^= arr[j];
        arr[j] ^= arr[i];
        arr[i] ^= arr[j];
    }

    public static int[] string2arr(String s, String separator) {
        String[] ss = s.split(separator);
        int[] arr = new int[ss.length];
        for (int i = 0; i < ss.length; i++) {
            arr[i] = Integer.valueOf(ss[i]);
        }
        return arr;
    }
}
