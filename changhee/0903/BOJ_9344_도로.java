/*
 *  09.03 김창희
 *  BOJ_9344_도로
 *
 *  [풀이]
 *  1. 크루스칼을 통해 mst를 구성하며 문제에서 제시된 간선이 있는지 판단한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] parent;
    static List<Node> graph=new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();

        int t= Integer.parseInt(br.readLine());
        for(int tc=1; tc<=t; tc++){
            st=new StringTokenizer(br.readLine());

            int n =Integer.parseInt(st.nextToken());
            int m =Integer.parseInt(st.nextToken());
            int q =Integer.parseInt(st.nextToken());
            int p =Integer.parseInt(st.nextToken());

            parent=new int[n+1];
            graph.clear();
            for(int i =0;i <n+1; i++) parent[i]=i;

            for(int i =0; i<m; i++){
                st=new StringTokenizer(br.readLine());
                int x= Integer.parseInt(st.nextToken());
                int y= Integer.parseInt(st.nextToken());
                int cost= Integer.parseInt(st.nextToken());
                graph.add(new Node(x,y,cost));
            }

            Collections.sort(graph, (o1,o2)->Integer.compare(o1.cost,o2.cost));
            boolean result  = isShortRoute(p,q);
            answer.append(result==true?"YES":"NO").append("\n");
        }
        System.out.println(answer);

    }
    public static boolean isShortRoute(int x,int y){
        for(Node node : graph){
            if(findParent(node.x) != findParent(node.y)){
                if((node.x == x && node.y == y) || node.x == y && node.y == x) return true;
                union(node.x, node.y);
            }
        }
        return false;
    }
    public static void union(int x, int y){
        x = findParent(x);
        y = findParent(y);

        if(x!=y) parent[x]=y;
    }
    public static int findParent(int x){
        if(parent[x] == x) return x;
        return parent[x]= findParent(parent[x]);
    }
    static class Node{
        int x,y,cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
}
