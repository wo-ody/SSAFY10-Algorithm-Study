import java.io.*;
import java.util.*;

public class BOJ_2887_행성터널 {
	static int[] root;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		List<List<int[]>> space = new ArrayList<>();
		for (int i=0; i<3; i++) space.add(new ArrayList<>());
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			space.get(0).add(new int[] {Integer.parseInt(st.nextToken()), i});
			space.get(1).add(new int[] {Integer.parseInt(st.nextToken()), i});
			space.get(2).add(new int[] {Integer.parseInt(st.nextToken()), i});
		}
		for (int i=0; i<3; i++) Collections.sort(space.get(i), (o1,o2)->o1[0]-o2[0]);

		PriorityQueue<int[]> heap = new PriorityQueue<>((o1,o2)->o1[2]-o2[2]);
		int t, s, e;
		for (int i=0; i<3; i++) {
			for (int j=0; j<n-1; j++) {
				t = Math.abs(space.get(i).get(j)[0] - space.get(i).get(j+1)[0]);
				s = space.get(i).get(j)[1]; e = space.get(i).get(j+1)[1];
				heap.add(new int[] {s,e,t});
			}
		}
		root = new int[n]; for (int i=0; i<n; i++) root[i] = i;

		int ans=0, cnt=0, now[];
		while (cnt<n-1) {
			now = heap.poll();
			s = now[0]; e = now[1]; t = now[2];
			if (union(s,e)) {
				ans += t;
				cnt++;
			}
		}
		System.out.println(ans);
	}//main
	
	static int find(int x) {
		return root[x]==x? x:(root[x]=find(root[x]));
	}
	
	static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x==y) return false;
		if (x<y) root[y] = x;
		else root[x] = y;
		return true;
	}
}
