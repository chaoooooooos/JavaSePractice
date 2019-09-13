package gc.exam.vivo.two;

import java.util.*;

/**
 * @author gengchao
 * @date 2019/9/11 16:08
 * @description：
 */
public class Main {
//    void helper() {
//        {
//            int jMax = min(w[n] - 1, c);
//            int kMax = min(b[n] - 1, d);
//            for (int j = 0; j <= jMax; j++)
//                for (int k = 0; k <= d; k++)
//                    m[n][j][k] = 0;
//            for (int k = 0; k <= kMax; k++)
//                for (int j = 0; j <= c; j++)
//                    m[n][j][k] = 0;
//            for (int j = w[n]; j <= c; j++)
//                for (int k = b[n]; k <= d; k++)
//                    m[n][j][k] = v[n];
//            for (int i = n - 1; i > 1; i--) {
//                jMax = min(w[i] - 1, c);
//                kMax = min(b[i] - 1, d);
//                for (int j = 0; j <= jMax; j++)
//                    for (int k = 0; k <= d; k++)
//                        m[i][j][k] = m[i + 1][j][k];
//                for (int k = 0; k <= kMax; k++)
//                    for (int j = 0; j <= c; j++)
//                        m[i][j][k] = m[i + 1][j][k];
//                for (int j = w[i]; j <= c; j++)
//                    for (int k = b[i]; k <= d; k++)
//                        m[i][j][k] = max(m[i + 1][j][k], m[i + 1][j - w[i]][k - b[i]] + v[i]);
//            }
//            m[1][c][d] = m[2][c][d];
//            if (c >= w[1] && d >= b[1]) m[1][c][d] = max(m[2][c][d], m[2][c - w[1]][d - b[1]] + v[1]);
//        }
//
//    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
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
