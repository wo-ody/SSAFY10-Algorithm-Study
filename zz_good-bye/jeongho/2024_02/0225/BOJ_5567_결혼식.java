package algorithm2024.feb.day25;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_5567_결혼식 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, m;
    static ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        int depth = 1;
        int ans = 0;
        boolean[] v = new boolean[n + 1];
        v[1] = true;
        while (!q.isEmpty()&&depth<=2) {
            int s = q.size();
            for (int i = 0; i < s; i++) {
                int cur = q.poll();
                for (int next : adjList.get(cur)) {
                    if(v[next])continue;
                    v[next] = true;
                    ans++;
                    q.offer(next);
                }
            }
            depth++;
        }
        System.out.println(ans);
    }
}
