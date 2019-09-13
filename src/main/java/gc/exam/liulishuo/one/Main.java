package gc.exam.liulishuo.one;

import java.util.*;

/**
 * @author gengchao
 * @date 2019/9/11 21:40
 * @description：
 */
class Main {
    public static int[] string2arr(String s, String separator) {
        String[] ss = s.split(separator);
        int[] arr = new int[ss.length];
        for (int i = 0; i < ss.length; i++) {
            arr[i] = Integer.valueOf(ss[i]);
        }
        return arr;
    }

    public static int helper(int[][] grid) {
        int res = 0;
        int n = grid.length;
        int m = grid[0].length;

        int[][] xy = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2)
                    q.offer(new int[]{i, j});
            }

        if (q.size() == 0 || q.size() == m * n) return -1;
        while (q.size() > 0) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cor = q.poll();
                int r = cor[0];
                int c = cor[1];
                for (int a = 0; a <= 3; a++) {
                    int x = xy[a][0] + r;
                    int y = xy[a][1] + c;
                    if (x >= 0 && x < n && y >= 0 && y < m && grid[x][y] == 3 && grid[x][y] != 1) {
                        q.offer(new int[]{x, y});
                        grid[x][y] = 0;
                    }
                }

            }
            res++;
        }
        return res - 1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] arr = new int[1000][1000];
        int rows = 0;
        int cols = 0;
        for(;;){
            try {
                String[] ss = in.nextLine().split(" ");
                cols = ss.length;
                for(int i=0;i<ss.length;i++){
                    arr[rows][i] = Integer.valueOf(ss[i]);
                }
                rows++;
            }catch (Exception e){
                int res = helper(arr);
                System.out.println(res);
                return;
            }

        }


    }


}