import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static List<Node> graph= new ArrayList<>();
	static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		parent=new int[n];
		
		for(int i =0; i<n; i++) parent[i]=i;
		
		double[][] info =new double[n][2];
		for(int i =0; i<n; i++) {
			st=new StringTokenizer(br.readLine());
			info[i][0] = Double.parseDouble(st.nextToken());
			info[i][1] = Double.parseDouble(st.nextToken());
		}
		
		for(int  i =0; i<n; i++) {
			for(int j =i+1; j<n; j++) {
				double cost = Math.sqrt(Math.pow(info[i][0]-info[j][0], 2) + Math.pow(info[i][1]-info[j][1], 2));
				graph.add(new Node(i,j,cost));
			}
		}
		
		Collections.sort(graph,(o1,o2)->Double.compare(o1.cost, o2.cost));
		double answer = kruskal();
		System.out.println(String.format("%.2f", answer));
		
	}
	public static double kruskal() {
		double result = 0;
		for(Node node  : graph) {
			if(findParent(node.x)!=findParent(node.y)) {
				union(node.x,node.y);
				result+=node.cost;
			}
		}
		return result;
	}
	public static void union(int x, int y) {
		x= findParent(x);
		y= findParent(y);
		
		if(x!=y) parent[x]=y;
	}
	public static int findParent(int x) {
		if(x==parent[x]) return x;
		return parent[x]=findParent(parent[x]);
	}
	static class Node{
		int x, y;
		double cost;

		public Node(int x, int y, double cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
		
	}
}
