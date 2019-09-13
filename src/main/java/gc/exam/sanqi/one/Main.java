package gc.exam.sanqi.one;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author gengchao
 * @date 2019/9/10 14:08
 * @description：
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] s = in.nextLine().split(":");
        String s1 = s[0];
        String s2 = s[1];
        int a = str2int(s1);
        int b = str2int(s2);
        if(a==0 && b==0){
            System.out.println(0);
            return;
        }
        s1 = String.valueOf(a);
        s2 = String.valueOf(b);

        int hour = -1;
        int minute = -1;
        List<Integer> list = new ArrayList<>();
        for(int i=24;i>=1;i--){
            try {
                hour = Integer.parseInt(s1,i);
                minute = Integer.parseInt(s2,i);
            }catch (Exception e){
                continue;
            }

            if(hour<=23 && minute<=59){
                list.add(i);
            }
//            else
//                break;
        }
        if(list.size()==0){
            System.out.println(-1);
        }else {
            Collections.sort(list);
            for(int x : list)
                System.out.print(x+" ");
        }

    }

    public static int str2int(String s){
        if(s.length()==0)
            return -1;
        int res = 0;
        for(char ch : s.toCharArray()){
            res = res*10+(ch-'0');
        }
        return res;
    }

}
