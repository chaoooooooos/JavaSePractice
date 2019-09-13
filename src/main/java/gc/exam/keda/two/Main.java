package gc.exam.keda.two;

import java.util.Scanner;

/**
 * @author gengchao
 * @date 2019/9/12 10:24
 * @description：
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int idx = 0;
        int cnt = 1;
        StringBuffer sb = new StringBuffer();
        while(idx+1<s.length()){
            if(idx+1<s.length() && s.charAt(idx+1)==s.charAt(idx)){
                cnt++;
                idx++;
            }else{
                if(cnt != 1)
                    sb.append(cnt).append(s.charAt(idx));
                else
                    sb.append(s.charAt(idx));
                cnt = 1;
                idx++;
            }
        }
        if(cnt != 1)
            sb.append(cnt).append(s.charAt(idx));
        else
            sb.append(s.charAt(idx));
        System.out.println(sb);
    }
}
