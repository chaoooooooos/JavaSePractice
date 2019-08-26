package gc.exam;// 本题为考试单行多行输入输出规范示例，无需提交，不计分。

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        in.nextLine();
        String[] strs = in.nextLine().split(" ");
        int[] arr = new int[strs.length];
        for (int i = 0; i < arr.length; i++)
            arr[i] = Integer.valueOf(strs[i]);
        int res = 0;
        for (int i = 0; i < arr.length; ) {
            int idx = i;
            int base = arr[i];
            int max = base;
            boolean f = false;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < base) {
                    i = j + 1;
                }

            }

            for (int k = idx; k < arr.length && k <= i; k++)
                max = Math.max(arr[k], max);
            while (i < arr.length && arr[i] < max)
                i++;
            res++;
            if (idx == i)
                i++;
        }
        System.out.println(res);
    }

}