package gc.leetcode;


import java.lang.reflect.Array;
import java.util.*;

class Solution {

    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};

    public int maxDistance(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int res = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (grid[i][j] == 1) {
                    queue.add(new int[]{i, j}); // 把所有的陆地都放入队列
                }
        if (queue.size() == n * m || queue.size() == 0)
            return -1;
        while (!queue.isEmpty()) {
            int sz = queue.size();
            res++;
            for (int i = 0; i < sz; i++) {
                int[] cur = queue.poll();
                for (int k = 0; k < 4; k++) {
                    int x = cur[0] + dx[k];
                    int y = cur[1] + dy[k];
                    if (x < 0 || x >= n || y < 0 || y >= m)
                        continue;
                    if (grid[x][y] == 1)
                        continue;
                    queue.add(new int[]{x, y});
                    grid[x][y] = 1;
                }
            }
        }
        return res - 1;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,0,1,0},{0,1,0,1},{1,0,0,0},{0,0,1,1}};
        System.out.println(new Solution().maxDistance(arr));
    }

}