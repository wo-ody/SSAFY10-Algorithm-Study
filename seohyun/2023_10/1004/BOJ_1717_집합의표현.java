package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1717_집합의표현 {
    static int n,m;

    static int[] parent;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parent = new int[n+1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(op == 0){
                union(a,b);
            }
            else{
                if(find(a) == find(b)) System.out.println("yes");
                else System.out.println("no");

            }
        }

    }

    static int find(int v){
        if(parent[v] == v) return v;
        else return parent[v] = find(parent[v]);
    }

    static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        parent[pa] = pb;
    }
}
