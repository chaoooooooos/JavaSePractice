package gc.exam.xiaomi.two;

import java.util.*;


/**
 * @author gengchao
 * @date 2019/9/6 18:36
 * @description：
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] ss = in.nextLine().split(" ");
        int m = Integer.valueOf(ss[0]);
        int s = Integer.valueOf(ss[1]);
        int t = Integer.valueOf(ss[2]);
        if (t == 0) {
            System.out.println("No");
            System.out.println(0);
            return;
        }
        if (s == 0) {
            System.out.println("Yes");
            System.out.println(0);
            return;
        }
        int time = 0;
        int distance = 0;
        while (m >= 10 && t > 0) {
            m -= 10;
            t--;
            time++;
            s -= 50;
            distance += 50;
            if (s <= 0) {
                System.out.println("Yes");
                System.out.println(time);
                return;
            }
        }
        while (true) {
            int need_t = (int) Math.ceil((10 - m) / 4.0);
            if (need_t < t) {
                //wait
                t -= need_t;
                time += need_t;
                m += 4*need_t;
                //flash
                time++;
                s -= 50;
                t--;
                m -= 10;
                distance += 50;
                if (s <= 0) {
                    System.out.println("Yes");
                    System.out.println(time);
                    return;
                }
            } else {
                while (t>0){
                    distance += 13;
                    t--;
                    time++;
                    s-=13;
                    if(s<=0){
                        System.out.println("Yes");
                        System.out.println(time);
                        return;
                    }
                }
                System.out.println("No");
                System.out.println(distance);
                return;
            }
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
