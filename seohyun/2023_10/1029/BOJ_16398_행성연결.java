1package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_16398_행성연결 {
    static int N;
    static PriorityQueue<Node> pq;

    static int[] parent;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        pq = new PriorityQueue<>((o1,o2)->o1.c - o2.c);
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int c = Integer.parseInt(st.nextToken());
                if(i <= j) continue;
                pq.add(new Node(i,j,c));
            }
        }

        System.out.println(simulation());
    }

    static void init(){
        parent = new int[N+1];
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }
    }

    static int find(int v){
        if(parent[v] == v) return v;
        else return parent[v] = find(parent[v]);
    }

    static void union(int a, int b){
        int pa = parent[a];
        int pb = parent[b];

        parent[pa] = pb;
    }

    static long simulation(){
        init();
        long result = 0;

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if(find(cur.a) != find(cur.b)){
                union(cur.a, cur.b);
                result += cur.c;
            }
        }
        return result;
    }

    static class Node{
        int a,b,c;
        Node(int a, int b, int c){
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
}
