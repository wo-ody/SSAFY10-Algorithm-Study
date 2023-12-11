/*
 *  08.31 김창희
 *  BOJ_1368_물대기
 *
 *  [풀이]
 *  1. 우물을 직접 팔때와 다른 논에서 끌어올때의 경우중 더 작은 비용을 선택해야한다.
 *  2. 하나의 임의의 논을 만들고 우물을 파는 경우를 간선으로 하여 MST를 찾는다
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] parent;
    static List<Node> graph = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());
        
        parent = new int[n+1];
        for(int i =0; i<n+1; i++) parent[i]=i;
            
        for(int i =0;i<n; i++) {
        	int cost = Integer.parseInt(br.readLine());
        	graph.add(new Node(i,n,cost));
        }
        
        for(int i =0; i<n; i++) {
            st=new StringTokenizer(br.readLine());
            for(int j =0; j<n; j++) {
                int cost = Integer.parseInt(st.nextToken());
                if(i==j) continue;
                graph.add(new Node(i,j,cost));
            }
        }
        
        Collections.sort(graph,(o1,o2)->Integer.compare(o1.cost, o2.cost));
        int answer = kruskal();
        System.out.println(answer);
        
        
    }
    
    public static int kruskal() {
        int result =0;
        for(Node node : graph) {
            if(findParent(node.x) != findParent(node.y)) {
            	union(node.x, node.y);
            	result+=node.cost;
            }
        }
        return result;
        
        
    }
    
    public static void union(int x, int y) {
        x= findParent(x);
        y= findParent(y);
        
        if(x>y) parent[x]=y;
        if(x<y) parent[y]=x;
    }
    
    public static int findParent(int x) {
        if(parent[x] == x) return x;
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
