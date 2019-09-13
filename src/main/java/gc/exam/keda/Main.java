package gc.exam.keda;


import java.util.*;

/**
 * @author gengchao
 * @date 2019/9/12 10:13
 * @description：
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String s1 = "";
        String s2 = "";
        boolean f = false;
        for (char ch : s.toCharArray()) {
            if (ch != ' ') {
                if (!f) {
                    s1 += ch;
                } else
                    s2 += ch;
            }else
                f = true;
        }

        System.out.println(bigNumAdd(s1,s2));
    }

    public static String bigNumAdd (String s1, String s2){
        if (s1.length() == 0 || s2.length() == 0)
            return "0";
        int len1 = s1.length();
        int len2 = s2.length();
        int[] res = new int[1 + (len1 > len2 ? len1 : len2)];
        int k = res.length - 1;
        int i = len1 - 1;
        int j = len2 - 1;
        while (i >= 0 || j >= 0) {
            if (i >= 0)
                res[k] += (s1.charAt(i--) - '0');
            if (j >= 0)
                res[k] += (s2.charAt(j--) - '0');
            k--;
        }

        for (int idx = res.length - 1; idx >= 1; idx--) {
            if (res[idx] > 9) {
                res[idx - 1] += 1;
                res[idx] %= 10;
            }
        }

        StringBuffer sb = new StringBuffer();
        for (int x : res) {
            if (sb.length() == 0 && x == 0)
                continue;
            sb.append(x);
        }
        if(sb.length()==0) return "0";
        return sb.toString();
    }
}
