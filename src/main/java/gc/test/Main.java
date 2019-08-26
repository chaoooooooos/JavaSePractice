package gc.test;

import java.util.*;


public class Main {
    static Queue visited = new LinkedList();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<int[]> list = new ArrayList<>();

        for(int t=0;t<100;t++){
            try {
                String[] strs = in.nextLine().split(" ");
                int[] arr = new int[strs.length];
                for (int i = 0; i < strs.length; i++)
                    arr[i] = Integer.valueOf(strs[i]);
                list.add(arr);
            }catch (Exception r){
                int[][] weight = new int[list.size()][list.get(0).length];
                for (int i = 0; i < list.size(); i++)
                    for (int j = 0; j < weight[0].length; j++)
                        weight[i][j] = list.get(i)[j];
                String[] str = new String[weight.length];
                for(int i=0;i<str.length;i++)
                    str[i] = String.valueOf(i);

                int[] dis = new int[list.size()];
                Arrays.fill(dis,Integer.MAX_VALUE);
                dijkstra(weight,str,0,dis);
                break;
            }

        }

    }

//    public static void main(String[] args) {
//        int[][] weigjt = {{0, 1, 12, -1, -1, -1},
//                         {-1, 0, 9, 3, -1, -1},
//                         {-1, -1, 0, -1, 5, -1},
//                         {-1, -1, 4, 0, 13, 15},
//                         {-1, -1, -1, -1, 0, 4},
//                         {-1, -1, -1, -1, -1, 0}};
//        int[] dis = new int[weigjt.length];
//        Object[] str = {"1","2","3","4","5","6"};
//        dijkstra(weigjt,str,0,dis);
//    }

        static void dijkstra ( int[][] weight, Object[] str,int v, int[] dis){
            for (int i = 0; i < str.length; i++) {
                if (i == v)
                    dis[i] = 0;
                else if (weight[v][i] != -1) {
                    dis[i] = weight[v][i];
                } else
                    dis[i] = Integer.MAX_VALUE;
            }
            visited.add(v);
            while (visited.size() < str.length) {
                int k = getIndex(visited, dis);
                visited.add(k);
                if (k != -1) {
                    for (int j = 0; j < str.length; j++) {
                        if (weight[k][j] != -1) {
                            if (dis[j] > dis[k] + weight[k][j])
                                dis[j] = dis[k] + weight[k][j];
                        }
                    }
                }
            }
            for (int i = 1; i < str.length; i++)
                System.out.println(dis[i]);
        }
        static int getIndex (Queue q,int[] dis){
            int k = -1;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < dis.length; i++) {
                if (!q.contains(i)) {
                    if (dis[i] < min) {
                        min = dis[i];
                        k = i;
                    }
                }
            }
            return k;
        }

    }


