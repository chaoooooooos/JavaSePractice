package gc.exam.Bigo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
    static int MAX = 200000;


    private static int bfs(int n, int k) {
        // TODO Auto-generated method stub
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(n);
        if (n == k) {
            return 0;
        }
        int[] min = new int[MAX + 5];
        boolean[] visited = new boolean[MAX + 5];
        visited[n] = true;
        while (!queue.isEmpty()) {
            int next = queue.remove();
            for (int i = 0; i < 3; i++) {
                int temp = next;
                if (i == 0) {
                    temp++;
                } else if (i == 1) {
                    temp--;
                } else if (i == 2) {
                    temp *= 2;
                }
                if (!visited[temp]) {
                    queue.offer(temp);
                    visited[temp] = true;
                    min[temp] = min[next] + 1;
                }
                if (temp == k) {
                    return min[k];
                }
            }
        }
        return 0;
    }

}