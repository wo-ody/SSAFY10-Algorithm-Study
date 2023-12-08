package boj;

import java.io.*;
import java.util.*;
public class boj_22233_가희와키워드 {
    static int N,M;
    static Set<String> memo = new HashSet<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            memo.add(br.readLine());
        }

        for (int i = 0; i < M; i++) {
            String input = br.readLine();
            String[] check = input.split(",");

            for(String s : check){
                if(memo.contains(s)) memo.remove(s);
            }

            sb.append(memo.size()).append("\n");
        }

        System.out.println(sb);

    }
}
