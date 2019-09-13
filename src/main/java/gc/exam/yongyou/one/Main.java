package gc.exam.yongyou.one;

import java.util.*;

/**
 * @author gengchao
 * @date 2019/9/11 13:54
 * @description：
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] ss = new String[2];
        int p = 0;
        for (char ch : s.toCharArray()) {
            if (ch >= '0' && ch <= '9') {
                p = p * 10 - '0' + ch;
            }
            if (ch == ',')
                break;
        }
        int start = s.indexOf('[') + 1;
        int end = s.indexOf(']');
        s = s.substring(start, end);
        int[] arr = string2arr(s, ",");

        ///////////////////////////////////////////
        Arrays.sort(arr);
        if (p < arr[0]) {
            System.out.println(0);
            return;
        }
        int max = 0;
        int power = p;
        for (int x : arr){
            power-=x;
            if(power>=0){
                max++;
            }else
                break;
        }
        System.out.println(max);

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
