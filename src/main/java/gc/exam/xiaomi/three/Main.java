    package gc.exam.xiaomi.three;

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
            int n = Integer.valueOf(ss[0]);
            int m = Integer.valueOf(ss[1]);
            int r = Integer.valueOf(ss[2]);
            int[] cities = string2arr(in.nextLine(), " ");
            int[][] arr = new int[n][n];
            for (int i = 0; i < arr.length; i++)
                Arrays.fill(arr[i], -1);

            for (int i = 0; i < m; i++) {
                String s = in.nextLine();
                int[] temp = string2arr(s, " ");
                //System.out.println("temp="+Arrays.toString(temp));
                int start = temp[0] - 1;
                int end = temp[1] - 1;
                int dis = temp[2];
                arr[start][end] = dis;
                arr[end][start] = dis;
            }
            List<int[]> list = new ArrayList<>();
            for (int x : cities) {
                list.add(getShortestPaths(arr, x - 1));
            }
            int res = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            for(int[] x : list)
                System.out.println(Arrays.toString(x));

            for(int[] diss : list){
                for(int city : cities)
                    max = Math.max(max,diss[city-1]);
                res = Math.min(max,res);
            }
            System.out.println(res);
        }

        public static int[] string2arr(String s, String separator) {
            String[] ss = s.split(separator);
            int[] arr = new int[ss.length];
            for (int i = 0; i < ss.length; i++) {
                arr[i] = Integer.valueOf(ss[i]);
            }
            return arr;
        }

        public static int[] getShortestPaths(int[][] adjMatrix, int start) {
            int[] result = new int[adjMatrix.length];   //用于存放顶点0到其它顶点的最短距离
            boolean[] used = new boolean[adjMatrix.length];  //用于判断顶点是否被遍历
            used[start] = true;  //表示顶点0已被遍历
            for (int i = 0; i < adjMatrix.length; i++) {
                if (i != start)
                    result[i] = adjMatrix[start][i];
            }
            //System.out.println("arr=" + Arrays.toString(result));
            for (int i = 0; i < adjMatrix.length; i++) {
                int min = Integer.MAX_VALUE;    //用于暂时存放顶点start到i的最短距离，初始化为Integer型最大值
                int k = 0;
                for (int j = 0; j < adjMatrix.length; j++) {  //找到顶点start到其它顶点中距离最小的一个顶点
                    if (!used[j] && result[j] != -1 && min > result[j]) {
                        k = j;
                        min = result[j];
                    }
                }
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


    }
