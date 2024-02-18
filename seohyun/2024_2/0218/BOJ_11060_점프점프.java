package boj;

import java.io.*;
import java.util.*;

public class boj_11060_점프점프 {
    static int N;
    static int[] map;

    static int result;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        map = new int[N];
        for (int i = 0; i < N; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(simulation());
    }

    static int simulation(){
        Queue<Integer> q = new ArrayDeque<>();
        int[] visited = new int[N];

        q.add(0);
        visited[0] = 0;

        while(!q.isEmpty()){
            int cur = q.poll();

            if(cur == N - 1){
                return visited[cur];
            }

            for (int i = 1; i <= map[cur]; i++) {
                int nxt = cur + i;
                if(nxt >= N || visited[nxt] != 0) continue;
                q.add(nxt);
                visited[nxt] = visited[cur] + 1;
            }
        }

        return -1;
    }
}
