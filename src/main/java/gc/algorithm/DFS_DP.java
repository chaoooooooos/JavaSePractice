package gc.algorithm;

public class DFS_DP {
    private int[][] heights = {
            {1, 2, 3, 4, 5},
            {16, 17, 18, 19, 6},
            {15, 24, 25, 20, 7},
            {14, 23, 22, 21, 8},
            {13, 12, 11, 10, 9}
    };
    private int[][] dp = new int[heights.length][heights[0].length];

    public static void main(String[] args) {
        new DFS_DP().helper();
    }

    public void helper() {
        int rows = heights.length;
        int cols = heights[0].length;
        int ans = -1;
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                ans = Math.max(ans, dfs(i, j));
        System.out.println(ans);
    }

    public int dfs(int i, int j) {
        int rows = heights.length;
        int cols = heights[0].length;
        int distance = -1;
        int nx, ny, l, r, u, d;
        if (dp[i][j] != 0)
            return dp[i][j];
        nx = i;
        ny = j - 1;
        if (check(nx, ny) && heights[nx][ny] < heights[i][j]) {
            l = dfs(nx, ny);
            distance = Math.max(distance, l);
        }
        nx = i - 1;
        ny = j;
        if (check(nx, ny) && heights[nx][ny] < heights[i][j]) {
            u = dfs(nx, ny);
            distance = Math.max(distance, u);
        }
        nx = i;
        ny = j + 1;
        if (check(nx, ny) && heights[nx][ny] < heights[i][j]) {
            r = dfs(nx, ny);
            distance = Math.max(distance, r);
        }
        nx = i + 1;
        ny = j;
        if (check(nx, ny) && heights[nx][ny] < heights[i][j]) {
            d = dfs(nx, ny);
            distance = Math.max(distance, d);
        }
        dp[i][j] = distance + 1;

        return dp[i][j];
    }

    public boolean check(int i, int j) {
        if (i < 0 || i >= heights.length || j < 0 || j >= heights[0].length)
            return false;
        return true;
    }
}
