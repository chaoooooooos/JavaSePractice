package gc.exam.jd;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] ss = in.nextLine().split(" ");
        int n = ss.length;
        int k = Integer.valueOf(in.nextLine());
        double[] arr = new double[n-k+1];
        double sum = 0;
        for(int i=0;i<k;i++){
            sum += Integer.valueOf(ss[i]);
        }
        System.out.print(String.format("%.2f", sum/k)+" ");
        for(int i=k;i<n;i++){
            sum -= Integer.valueOf(ss[i-k]);
            sum += Integer.valueOf(ss[i]);
            System.out.print(String.format("%.2f", sum/k)+" ");
        }

    }



}

