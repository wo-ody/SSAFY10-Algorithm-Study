import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        boolean[] broken = new boolean[10];

        if(M!=0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                int temp = Integer.parseInt(st.nextToken());
                broken[temp] = true;
            }
        }

        int result = Math.abs(N - 100);

        for (int i = 0; i <= 999999; i++) {
            String num = String.valueOf(i);

            boolean isBreak = false;
            for (int j = 0; j < num.length(); j++) {
                if (broken[num.charAt(j) - '0']) {
                    isBreak = true;
                    break;
                }
            }

            if (!isBreak) {
                int min = Math.abs(N - i) + num.length();
                result = Math.min(min, result);
            }
        }

        System.out.println(result);
    }
}
