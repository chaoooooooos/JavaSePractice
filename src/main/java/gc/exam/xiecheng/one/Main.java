package gc.exam.xiecheng.one;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author gengchao
 * @date 2019/9/4 18:36
 * @description：
 */
public class Main {
    public static void main(String[] args) {

        System.out.println(resolve(""));
    }

    static int schedule(int m, int[] arr) {
        if (m == 1) {
            int sum = 0;
            for (int x : arr)
                sum += x;
            return sum;
        }
        int max = Integer.MIN_VALUE;
        int[][] temp = new int[arr.length][2];
        for (int i = 0; i < arr.length; i++) {
            temp[i][0] = arr[i];
            temp[i][1] = i;
            max = Math.min(arr[i], max);
        }
        Arrays.sort(temp, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });
        int[][] idxs = new int[m][2];

        for (int i = 0; i < m; i++) {
            if (i >= arr.length - 1)
                return max;
            idxs[i][0] = temp[i][0];
            idxs[i][1] = temp[i][1];
        }
        Arrays.sort(idxs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int res = Integer.MIN_VALUE;
        int idx = -1;
        boolean[] v = new boolean[arr.length];
        for (int i = 0; i < idxs.length; i++) {
            int sum = 0;

            for (int k = idx+1; k <= idxs[i][1]; k++) {

                sum += arr[k];
                idx = k;
            }


            res = Math.max(res, sum);
        }

        return res;
    }


    static String resolve(String str) {
//        if(str==null || str.length()==0)
//            return "";
        int cnt = 0;
        for (char ch : str.toCharArray()) {
            if (ch == '(')
                cnt++;
            else if (ch == ')')
                cnt--;
        }
        if (cnt != 0)
            return "";
        Stack<Character> stack = new Stack<>();
        StringBuffer sb = new StringBuffer();
        StringBuffer help = new StringBuffer();
        for (char ch : str.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.size() == 0)
                    return "";
                if (stack.peek() != '(')
                    return "";
                sb.reverse();
                stack.pop();
                if (stack.size() == 0) {
                    help.append(sb);
                    sb.setLength(0);
                }

            } else {
                if (stack.size() == 0) {
                    help.append(ch);
                } else
                    sb.append(ch);
            }

        }
        if (stack.size() != 0)
            return "";
        help.append(sb);
        return help.toString();
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
