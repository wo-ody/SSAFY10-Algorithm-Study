import java.util.*;
import java.io.*;
public class BOJ_4286_별자리만들기 {
	static boolean[] visit;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		
		Star[] stars = new Star[n];
		float x, y;
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			x = Float.parseFloat(st.nextToken());
			y = Float.parseFloat(st.nextToken());
			stars[i] = new Star(x, y);
		}
		visit = new boolean[n];
		PriorityQueue<Node> q = new PriorityQueue<>((s1, s2)->s1.dist<s2.dist? -1:1);
		q.add(new Node(0, 0));
		float ans=0, cnt = 0;
		Node now;
		while (!q.isEmpty()) {
			now = q.poll();
			if (visit[now.idx]) continue;
			ans += now.dist;
			cnt++;
			if (cnt==n) break;
			visit[now.idx]=true;
			for (int i=0; i<n; i++) {
				if (visit[i]) continue;
				q.add(new Node(i, dist(stars[i], stars[now.idx])));
			}
		}
		System.out.println(Math.round(ans*100)/100.0);
	}

	static float dist(Star a, Star b) {
		return (float) Math.pow((a.x-b.x)*(a.x-b.x) + (a.y-b.y)*(a.y-b.y), 0.5);
	}
	
	static class Node{
		int idx;
		float dist;
		Node(int idx, float dist){
			this.idx = idx; this.dist = dist;
		}
	}
}

class Star{
	float x, y;
	public Star(float x, float y) {
		this.x=x; this.y=y;
	}
}