package bitmask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_10726_이진수_표현 {
    static int T;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int temp = (1 << n) - 1;
            sb.append("#").append(t).append(" ");
            if (temp == (m & temp)) sb.append("ON").append("\n");
            else sb.append("OFF").append("\n");
        }
        System.out.println(sb.toString());
    }
}
