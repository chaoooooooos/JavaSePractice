package gc.exam.vivo.one;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author gengchao
 * @date 2019/9/11 16:07
 * @description：
 */

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = br.readLine();
        String[] input = inputStr.split(" ");
        int totalDisk = Integer.parseInt(input[0]);
        int totalMemory = Integer.parseInt(input[1]);
        List<Service> services = parseServices(input[2].split("#"));
        int output = solution(totalDisk, totalMemory, services);

        System.out.println(output);
    }

    public int max(int... xx) {
        int res = Integer.MIN_VALUE;
        for (int x : xx)
            res = Math.max(res, x);
        return res;
    }

    private static int solution(int totalDisk, int totalMemory, List<Service> services) {
        int n = services.size();
        int[][][] dp = new int[n + 1][totalDisk + 1][totalMemory + 1];
        for (int i = 1; i <= n; i++) {
            Service service = services.get(i - 1);
            int disk = service.getDisk();
            int mem = service.getMemory();
            int num = service.getusers();
            for (int j = 1; j <= totalDisk; j++) {
                for (int k = 1; k <= totalMemory; k++) {
                    if (j - disk >= 0 && k - mem >= 0) {
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - disk][k - mem] + num);
                    }
                }
            }
        }

        return dp[n][totalDisk][totalMemory];
    }

    private static List<Service> parseServices(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return new ArrayList<Service>(0);
        }
        List<Service> services = new ArrayList<>(strArr.length);
        for (int i = 0; i < strArr.length; i++) {
            String[] serviceArr = strArr[i].split(",");
            int disk = Integer.parseInt(serviceArr[0]);
            int memory = Integer.parseInt(serviceArr[1]);
            int users = Integer.parseInt(serviceArr[2]);
            services.add(new Service(disk, memory, users));
        }
        return services;
    }

    static class Service {
        private int disk;

        private int memory;

        private int users;

        @Override
        public String toString() {
            return "Service{" +
                    "disk=" + disk +
                    ", memory=" + memory +
                    ", users=" + users +
                    '}';
        }

        public Service(int disk, int memory, int users) {
            this.disk = disk;
            this.memory = memory;
            this.users = users;
        }

        public int getDisk() {
            return disk;
        }

        public void setDisk(int disk) {
            this.disk = disk;
        }

        public int getMemory() {
            return memory;
        }

        public void setMemory(int memory) {
            this.memory = memory;
        }

        public int getusers() {
            return users;
        }

        public void setusers(int users) {
            this.users = users;
        }
    }
}