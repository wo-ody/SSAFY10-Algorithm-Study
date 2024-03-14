package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_1922_네트워크_연결 {
    static int N, M;
    static ArrayList<Node> list = new ArrayList<>();
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        parent = new int[N+1];
        StringTokenizer st;

        for(int m = 0; m < M; m++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list.add(new Node(start, end, cost));
        }

        for(int n = 1; n <= N; n++) parent[n] = n;
        Collections.sort(list);
        System.out.println(list);
        int sum = 0;
        for(Node node: list){
            if(union(node.start, node.end)){
                sum += node.cost;
            }
        }

        System.out.println(sum);
    }
    static boolean union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);
        if(aRoot == bRoot) return false;
        else parent[aRoot] = bRoot;
        return true;
    }

    static int find(int v){
        if(parent[v] == v) return v;
        else return parent[v] = find(parent[v]);
    }
    static class Node implements Comparable<Node> {
        int start, end, cost;
        StringBuilder sb = new StringBuilder();

        public Node(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        @Override
        public String toString(){
            sb.append("(").append(start).append(" , ").append(end).append(" , ").append(cost).append(")");
            return sb.toString();
        }
        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
