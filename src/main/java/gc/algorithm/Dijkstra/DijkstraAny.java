package gc.algorithm.Dijkstra;

import java.util.Arrays;

public class DijkstraAny {
    /*
     * 参数adjMatrix:为图的权重矩阵，权值为-1的两个顶点表示不能直接相连
     * 函数功能：返回顶点start到其它所有顶点的最短距离，其中顶点start到顶点start的最短距离为0
     * 在稀疏矩阵的时候，堆优化更快，稠密矩阵这种方式可能要好一点
     */
    public int[] getShortestPaths(int[][] adjMatrix, int start) {
        int[] result = new int[adjMatrix.length];   //用于存放顶点0到其它顶点的最短距离
        boolean[] used = new boolean[adjMatrix.length];  //用于判断顶点是否被遍历
        used[start] = true;  //表示顶点0已被遍历
        for (int i = 0; i < adjMatrix.length; i++) {
            if (i != start)
                result[i] = adjMatrix[start][i];
        }
        System.out.println("arr="+Arrays.toString(result));
        for (int i = 0; i < adjMatrix.length; i++) {
            int min = Integer.MAX_VALUE;    //用于暂时存放顶点start到i的最短距离，初始化为Integer型最大值
            int k = 0;
            for (int j = 0; j < adjMatrix.length; j++) {  //找到顶点start到其它顶点中距离最小的一个顶点
                if (!used[j] && result[j] != -1 && min > result[j]) {
                    k = j;
                    min = result[j];
                }
            }
            System.out.println("k="+k);
            used[k] = true;    //将距离最小的顶点，记为已遍历
            for (int j = 0; j < adjMatrix.length; j++) {  //然后，将顶点start到其它顶点的距离与加入中间顶点k之后的距离进行比较，更新最短距离
                if (!used[j]) {  //当顶点j未被遍历时
                    //首先，顶点k到顶点j要能通行；这时，当顶点start到顶点j的距离大于顶点start到k再到j的距离或者顶点start无法直接到达顶点j时，更新顶点0到顶点j的最短距离
                    if (adjMatrix[k][j] != -1 && (result[j] > min + adjMatrix[k][j] || result[j] == -1))
                        result[j] = min + adjMatrix[k][j];
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        DijkstraAny test = new DijkstraAny();
        int[][] adjMatrix = {
                {0, 6, 3, -1, -1, -1},
                {6, 0, 2, 5, -1, -1},
                {3, 2, 0, 3, 4, -1},
                {-1, 5, 3, 0, 2, 3},
                {-1, -1, 4, 2, 0, 5},
                {-1, -1, -1, 3, 5, 0}
        };
        int[] result = test.getShortestPaths(adjMatrix,1);
        System.out.println("顶点0到图中所有顶点之间的最短距离为：");
        for (int i = 0; i < result.length; i++)
            System.out.print(result[i] + " ");
    }
}