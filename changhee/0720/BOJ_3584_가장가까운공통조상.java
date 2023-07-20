
/**
 * 7.20 김창희
 * 백준_3584_가장가까운공통조상
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static List<List<Integer>> tree;
	static int[] parent, depth;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder answer= new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		for(int tc = 0; tc<t; tc++) {
			int n =Integer.parseInt(br.readLine());
			
			tree = new ArrayList<>();
			parent = new int[n+1];
			depth = new int[n+1];
			
			for(int i=0; i<n+1; i++) tree.add(new ArrayList<>());
			
			//depth를 공편하게 계산하기 위해 root를 구한다.
			int[] rootCost = new int[n+1];
			int rootIdx = 0;
			
			for(int i =0; i<n-1; i++) {
				st =new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				tree.get(u).add(v);
				
				rootCost[v]++;
			}
			
			for(int i =1; i<n+1; i++) {
				if(rootCost[i]==0) {
					rootIdx=i;
					break;
				}
			}
						
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			setDepthAndParnet(rootIdx,0); //두 정점의 depth를 동일하게 위치시키고, parent로 한칸씩 이동시키며 공통 조상을 찾는다.
			int result = lca(u,v);
			
			answer.append(result).append("\n");
		}
		
		System.out.println(answer);

	}
	private static int lca(int u, int v) {
		int uDepth = depth[u];
		int vDepth = depth[v];
		
		if(uDepth>vDepth) {
			while(uDepth!=vDepth) {
				uDepth--;
				u=parent[u];
			}
		}else {
			while(uDepth!=vDepth) {
				vDepth--;
				v=parent[v];
			}
		}
		
		while(u!=v) {
			u=parent[u];
			v=parent[v];
		}
		return u;
	}
	private static void setDepthAndParnet(int rootIdx, int dist) {
		Queue<int[]> q= new LinkedList<>();
		q.offer(new int[] {rootIdx, dist});
		
		while(!q.isEmpty()) {
			int[] node = q.poll();
			
			for(int nx : tree.get(node[0])) {
				if(depth[nx]!=0) continue;
				depth[nx] = node[1]+1;
				parent[nx] = node[0];
				q.offer(new int[] {nx,node[1]+1});
			}
		}
	}
}
