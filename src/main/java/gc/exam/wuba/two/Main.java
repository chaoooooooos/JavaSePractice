package gc.exam.wuba.two;

import java.util.*;

/**
 * @author gengchao
 * @date 2019/9/12 19:52
 * @description：
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = string2arr(in.nextLine(), ",");
        Set<Integer> set = new HashSet<>();
        for (int x : arr)
            set.add(x);
        System.out.println(set.size());

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
