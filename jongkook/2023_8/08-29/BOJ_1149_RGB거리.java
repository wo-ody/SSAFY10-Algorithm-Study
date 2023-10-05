import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] pay = new int[n][3];
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            pay[i][0] = Integer.parseInt(st.nextToken());
            pay[i][1] = Integer.parseInt(st.nextToken());
            pay[i][2] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i < n; i++){
            pay[i][0] += Math.min(pay[i-1][1], pay[i-1][2]);
            pay[i][1] += Math.min(pay[i-1][0], pay[i-1][2]);
            pay[i][2] += Math.min(pay[i-1][1], pay[i-1][0]);
        }
//        for(int i = 0; i < n; i++) System.out.println(Arrays.toString(pay[i]));
        System.out.println(Math.min(Math.min(pay[n-1][0], pay[n-1][1]), pay[n-1][2]));

    }
}
