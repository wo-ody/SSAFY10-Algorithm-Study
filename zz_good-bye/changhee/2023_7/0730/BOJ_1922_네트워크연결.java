/*
 *	7.30 김창희
 *	BOJ_1922_네트워크연결
 *
 *	[풀이]
 *	1. 최소비용사이클 = 크루스칼
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main{
    static List<Node> graph =new ArrayList<>();
    static int[] parent;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n =Integer.parseInt(br.readLine());
        int m =Integer.parseInt(br.readLine());

        parent=new int[n+1];
        for(int i =0; i<n+1; i++) parent[i] = i;

        for(int i=0; i<m; i++){
            st= new StringTokenizer(br.readLine());
            graph.add(new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }

        Collections.sort(graph,(o1,o2)->Integer.compare(o1.cost,o2.cost));
        int answer = kruskal();
        System.out.println(answer);

    }

    private static int kruskal() {
        int cost = 0;
        for(Node node :graph){
            if(findParent(node.x)!=findParent(node.y)){
                union(node.x,node.y);
                cost+= node.cost;
            }
        }
        return cost;
    }

    private static void union(int x, int y) {
        x=findParent(x);
        y=findParent(y);

        if(x>y) parent[x]=y;
        if(x<y) parent[y]=x;
    }

    private static int findParent(int x) {
        if(parent[x]==x) return x;
        return parent[x] = findParent(parent[x]);
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
