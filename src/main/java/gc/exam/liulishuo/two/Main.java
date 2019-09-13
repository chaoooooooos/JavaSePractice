package gc.exam.liulishuo.two;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author gengchao
 * @date 2019/9/11 21:40
 * @description：
 */
public class Main {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//
//        int n = Integer.valueOf(in.nextLine());
//        String s = in.nextLine();
//        int a = string2arr(s, " ")[0];
//        int b = string2arr(s, " ")[1];
//        int[][] arr1 = new int[n][2];
//        int[][] arr2 = new int[n][2];
//        boolean[] v1 = new boolean[n];
//        boolean[] v2 = new boolean[n];
//        for (int i = 0; i < n; i++) {
//            s = in.nextLine();
//            int x = string2arr(s, " ")[0];
//            int y = string2arr(s, " ")[1];
//            arr1[i][0] = x;
//            arr1[i][1] = i;
//            arr2[i][0] = y;
//            arr2[i][1] = i;
//        }
//        Arrays.sort(arr1, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o2[0] - o1[0];
//            }
//        });
//        Arrays.sort(arr2, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o2[0] - o1[0];
//            }
//        });
//        int res = 0;
//        while (n >= 1) {
//            if (a > 0 && b > 0) {
//                while (arr1[n - 1][0] < arr2[n - 1][0]) {
//                    int idx = arr1[n - 1][1];
//                    if (!v1[idx]) {
//                        res += arr1[n - 1][0];
//                        v1[idx] = true;
//                        a--;
//                        break;
//                    }
//                }
//            } else {
//                while (arr1[n - 1][0] > arr2[n - 1][0]) {
//                    int idx = arr2[n - 1][1];
//                    if (!v2[idx]) {
//                        res += arr2[n - 1][0];
//                        v2[idx] = true;
//                        b--;
//                        break;
//                    }
//                }
//            }
//        }
//    } else if(a >0)
//
//    {
//        res += arr1[n - 1][1];
//        a--;
//    } else if(b >0)
//
//    {
//        b--;
//        res += arr2[n - 1];
//    }
//
//    n--;
//}
//        System.out.println(res);
                }

public static int[]string2arr(String s,String separator){
        String[]ss=s.split(separator);
        int[]arr=new int[ss.length];
        for(int i=0;i<ss.length;i++){
        arr[i]=Integer.valueOf(ss[i]);
        }
        return arr;
        }
        }