import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int n = 1;
	static int[][] maps;
	static int[][] cost;
	static int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static Queue<Link> q;
	static final int Inf = Integer.MAX_VALUE;
	static int i = 1;
	
	public static void main(String[] args) throws IOException {
		while(true) {
			n = Integer.parseInt(br.readLine());
			if(n == 0)
				break;
			makemap();
			dijkstra();
			sb.append("Problem ").append(i++).append(": ").append(cost[n-1][n-1]).append("\n");
		}
		System.out.println(sb);
	}
	
	static void dijkstra() {  // 다익스트라의 성질을 가진 bfs
		cost[0][0] = maps[0][0];
		q = new ArrayDeque<Link>();
		q.offer(new Link(0, 0));
		
		while(!q.isEmpty()) {
			Link current = q.poll();
			int y = current.y;
			int x = current.x;
			for (int[] d : direction) {
				int my = y + d[0];
				int mx = x + d[1];
				if(valid_check(my, mx) && cost[y][x] + maps[my][mx] < cost[my][mx]) { 
					// 현재 노드의 비용 + 이동하려는 노드의 비용이 이동하려는 노드의 자체 비용보다 저렴하다면 -> 즉 현재 노드를 거쳐가는 것이 더 저렴하다면
					cost[my][mx] = cost[y][x] + maps[my][mx];
					q.offer(new Link(my, mx));
				}
			}
		}
	}
	
	static boolean valid_check(int y, int x) {
		if(0 <= y && y < n && 0 <= x && x < n)
			return true;
		return false;
	}
	
	static void makemap() throws IOException {
		maps = new int[n][n];
		cost = new int[n][n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				maps[i][j] = Integer.parseInt(st.nextToken());
				cost[i][j] = Inf;
			}
		}
	}
	
	static class Link {
		int y, x;
		Link(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
