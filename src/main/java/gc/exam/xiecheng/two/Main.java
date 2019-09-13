package gc.exam.xiecheng.two;

import java.util.Scanner;

/**
 * @author gengchao
 * @date 2019/9/4 18:36
 * @description：
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(resolve("(ab(cd))"));


    }

    public static String resolve(String s) {
        if (s == null || s.length() == 0)
            return "";
        char[] chs = s.toCharArray();
        int cnt = 0;
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            while (left <= right && chs[left] != '(') {
                left++;
            }
            if (chs[left] == '(') {
                left++;
                cnt++;
            }
            while (left <= right && chs[right] != ')')
                right--;
            if (chs[right] == ')') {
                right--;
                cnt--;
            }
            reverse(chs, left, right);
        }
        if (cnt != 0) return "";
        StringBuffer sb = new StringBuffer();
        for (char ch : chs)
            if (ch != '(' && ch != ')')
                sb.append(ch);
        return sb.toString();
    }

    public static void reverse(char[] chs, int start, int end) {
        while (start <= end) {
            char t = chs[start];
            chs[start] = chs[end];
            chs[end] = t;
            end--;
            start++;
        }
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
