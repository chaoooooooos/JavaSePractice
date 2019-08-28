package gc.algorithm.Dijkstra.practice;

public class Dijkstra {
    public int[] getShortDis(int[][] arr, int start) {
        if (arr.length == 0 || arr[0].length == 0 || start >= arr.length)
            return null;
        int[] res = new int[arr.length];
        boolean[] used = new boolean[arr.length];
        for (int i = 0; i < arr.length; i++)
            res[i] = arr[start][i];
        used[start] = true;
        for (int i = 0; i < arr.length; i++) {
            int idx = 0;
            int min = Integer.MAX_VALUE;
            // 找到谁距离start最近
            for (int j = 0; j < arr.length; j++) {
                if (res[j] != -1 && res[j] < min && !used[j]) {
                    idx = j;
                    min = res[j];
                }
            }
            used[idx] = true;
            // 更新各个点的距离
            for (int j = 0; j < arr.length; j++) {
                if (!used[j]) {
                    // 注意这个条件
                    if (arr[idx][j] != -1 && (res[j] == -1 || res[j] > arr[idx][j] + min))
                        res[j] = arr[idx][j] + min;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Dijkstra test = new Dijkstra();
        int[][] adjMatrix = {
                {0, 6, 3, -1, -1, -1},
                {6, 0, 2, 5, -1, -1},
                {3, 2, 0, 3, 4, -1},
                {-1, 5, 3, 0, 2, 3},
                {-1, -1, 4, 2, 0, 5},
                {-1, -1, -1, 3, 5, 0}
        };
        int start = 1;
        int[] result = test.getShortDis(adjMatrix, start);
        System.out.println(String.format("顶点%d到图中所有顶点之间的最短距离为：",start));
        for (int i = 0; i < result.length; i++)
            System.out.print(result[i] + " ");
    }

}












