package gc.exam.aiqiyi.two;

import java.util.*;

/**
 * @author gengchao
 * @date 2019/9/8 15:01
 * @description：
 */
public class Main {


    public static double getP(int n, int m) {
        double[][] dp = new double[n + 1][m + 1];
        for (int i = 1; i < n + 1; i++) {
            dp[i][0] = 1.0;
            double r = i / (double) (i + 1);
            dp[i][1] = r;
            r = i / (double) (i + 2);
            double b = 2 / (double) (i + 2);
            double bb = 1 / (double) (i + 1);
            dp[i][2] = r + b * bb;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 3; j < m + 1; j++) {
                double r = i / (double) (i + j);
                double b = j / (double) (i + j);
                double bb = (j - 1) / (double) (i + j - 1);
                double bbr = i / (double) (i + j - 2);
                double bbb = (j - 2) / (double) (i + j - 2);
                dp[i][j] = r + b * bb * bbr * dp[i - 1][j - 2] + b * bb * bbb * dp[i][j - 3];
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] ss = in.nextLine().split(" ");
        int red = Integer.valueOf(ss[0]);
        int blue = Integer.valueOf(ss[1]);
        if (red == 0) {
            System.out.println("0.00000");
            return;
        }
        if (blue == 0) {
            System.out.println("1.00000");
            return;
        }

        System.out.println(String.format("%.5f", helper(red, blue)));

    }

    static double[][] dp = new double[1001][1001];

    static double helper(int red, int blue) {
        if (blue > 1000 || red > 1000) return 0;
        if (blue == 0) return 1;
        if (red == 0) return 0;
        if (dp[red][blue] != 0) return dp[red][blue];
        double a = (double) (red) / (double) (red + blue);
        double b = (double) (blue) / (double) (red + blue);

        dp[red][blue] += a * helper(red - 1, blue - 1) + b * helper(red, blue - 2);

//        if(blue>=2)
//            dp[red][blue] += a * helper(red - 1, blue - 2)+helper(red - 1, blue - 2);
//        if(red>=2)
//            dp[red][blue] += a * helper(red - 2, blue - 1);
//        if(blue>=3)
//            dp[red][blue] += b * helper(red, blue - 3);
//        if (blue >= 2)
//            dp[red][blue] = a * helper(red - 1, blue - 1) + b * helper(red, blue - 2);
//        else
//            dp[red][blue] = a * helper(red - 1, blue - 1);


        return dp[red][blue];
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
