package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1107_리모컨 {
    static int channel, n, min = Integer.MAX_VALUE;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        channel = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());

        boolean[] brokens = new boolean[10];

        if(channel == 100){
            System.out.println(0);
            return;
        }

        if(n != 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                int b = Integer.parseInt(st.nextToken());
                brokens[b] = true;
            }
        }

        int decreseChannel = 999_999;
        while(decreseChannel >= 0){
            String str = String.valueOf(decreseChannel);

            for(int s = 0; s < str.length(); s++){
                int currentCharAt = str.charAt(s) - '0';
                if(brokens[currentCharAt]) {
                    sb.setLength(0);
                    break;
                }
                sb.append(currentCharAt);
            }
            if(sb.isEmpty()) {
                decreseChannel--;
                continue;
            }
            int minGap = Math.abs(Integer.parseInt(sb.toString()) - channel) + String.valueOf(decreseChannel).length();

            min = Math.min(min,minGap);
            sb.setLength(0);

            decreseChannel--;
        }

        System.out.println(Math.min(Math.abs(channel - 100), min));
    }
}
