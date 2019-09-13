package gc.exam.xiaomi.one;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author gengchao
 * @date 2019/9/6 18:36
 * @description：
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

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
