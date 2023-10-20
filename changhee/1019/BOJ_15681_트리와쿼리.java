import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
 
public class Main {

	static ArrayList<Integer>[] list, tree;
	static int parent[], size[];
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(stk.nextToken());
		int r = Integer.parseInt(stk.nextToken());
		int q = Integer.parseInt(stk.nextToken());
		
		parent = new int [n+1];
		size = new int[n+1];
		list = new ArrayList[n+1];
		tree = new ArrayList[n+1];
		
		for(int i=0; i<list.length; i++) {
			list[i] = new ArrayList<>();
			tree[i] = new ArrayList<>();
		}
		
		for(int i=1; i<n; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(stk.nextToken());
			int v = Integer.parseInt(stk.nextToken());
			
			list[u].add(v);
			list[v].add(u);
		}
		
		makeTree(r, -1);
		countSubtreeNodes(r);
		StringBuffer sb = new StringBuffer();
		while(q-- > 0) {
			int query = Integer.parseInt(br.readLine());
			
			sb.append(size[query]).append("\n");
		}
		System.out.println(sb);
	}

	public static void makeTree(int curNode, int p) {
		
		for(int node : list[curNode]) {
			if(node != p) {
				tree[curNode].add(node);
				parent[node] = curNode;
				makeTree(node, curNode);
			}
		}
	}
	
	public static void countSubtreeNodes(int curNode) {
		size[curNode] = 1;
		
		for(int node : tree[curNode]) {
			countSubtreeNodes(node);
			size[curNode] += size[node];
		}
	}
}
