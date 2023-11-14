import java.io.*;
import java.util.*;
public class Main {
	static int[][] root;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		root = new int[n][3];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) {
			root[i][0] = i;
			root[i][1] = 1;
			root[i][2] = Integer.parseInt(st.nextToken());
		}
		
		for (int i=0; i<m; i++) {
			st= new StringTokenizer(br.readLine());
			union(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1);
		}
		
		List<int[]> packs = new LinkedList<>();
		for (int i=0; i<n; i++) {
			if (root[i][0] == i) packs.add(new int[] {root[i][1],root[i][2]});
		}
		Collections.sort(packs,(o1,o2)->o2[1]-o1[1]);
		int[] bag = new int[k];
		for (int[] pack:packs ) {
			for (int i=k-1; i>=pack[0]; i--) {
				bag[i] = Math.max(bag[i], bag[i-pack[0]]+pack[1]);
			}
		}
		System.out.println(bag[k-1]);
	}
	
	static int find(int x) {
		return root[x][0]==x? x:(root[x][0] = find(root[x][0]));
	}
	
	static void union(int x, int y) {
		x = find(x); y = find(y);
		if (x>y) {
			int t = x; x=y; y=t;
		}else if(x==y) return;
		
		root[y][0] = x; root[x][1]+=root[y][1]; root[x][2]+=root[y][2]; 
	}
}
