package algorithm2024.mar.day24;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_4158_CD {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        while(true){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            HashSet<Integer> cd = new HashSet<>();

            if(N==0&&M==0)break;
            int ans= 0;

            for (int i = 0; i < N; i++) {
                cd.add(Integer.parseInt(br.readLine()));
            }

            for (int i = 0; i < M; i++) {
                int c = Integer.parseInt(br.readLine());
                if(cd.contains(c))ans++;
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);

    }
}
