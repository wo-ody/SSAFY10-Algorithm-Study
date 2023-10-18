import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static List<Node> grpah = new ArrayList<>();
	static int[] parent;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st=new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		
		parent=new int[n+1];
		for(int i =0; i<n+1; i++) {
			parent[i] = i;
		}
		
		for(int i =0; i<m; i++) {
			st=new StringTokenizer(br.readLine());
			int x= Integer.parseInt(st.nextToken());
			int y= Integer.parseInt(st.nextToken());
			int cost= Integer.parseInt(st.nextToken());
			grpah.add(new Node(x,y,cost));
			grpah.add(new Node(y,x,cost));
		}
		
		Collections.sort(grpah,(o1,o2)->Integer.compare(o1.cost,o2.cost));
		int answer = kruskal(t);
		System.out.println(answer);
	}
	
	public static int kruskal(int t) {
		int result = 0;
		int weight = 0;
		for(Node node : grpah) {
			if(findParent(node.x)!= findParent(node.y)) {
				union(node.x, node.y);
				result += node.cost + (weight*t);
				weight++;
			}
		}
		return result;
	}
	
	public static void union(int x, int y) {
		x=findParent(x);
		y=findParent(y);
		if(x!=y) parent[x]=y;
	}
	
	public static int findParent(int x) {
		if(parent[x]==x)return x;
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
