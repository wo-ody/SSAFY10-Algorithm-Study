/*	
 *	7.27 김창희
 *	BOJ_17472_다리만들기2
 * 
 * 	[풀이]
 *	1.구역별로 numbering
 *	2.방향을 유지하며 탐색하다 서로 다른 numbering 쌍을 찾아서 저장  	
 * 	3.크루스칼로 최소비용 사이클 구성
 * 	4.사이클이 발생하지 않았다면 answer = -1
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static List<Node> graph = new ArrayList<>();
	static int[][] map;
	static int[] parent;
	static int[] dx = { -1, 0, 1, 0 }, dy = { 0, 1, 0, -1 };
	static int n, m;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int numbering = 2;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1)
					partition(i, j, numbering++);
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] != 0)
					makeBridge(i, j);
			}
		}
		
		parent = new int[numbering];
		for(int i =0; i<numbering; i++) parent[i]=i;
		
		//크루스칼 - 한번의 사이클을 구성하는데 최소 비용을 고른다
		Collections.sort(graph, (o1,o2)->Integer.compare(o1.cost, o2.cost));
		
		int answer = kruskal();
		
		//크루스칼로 사이클이 발생했다면 모든 노드의 부모는 동일하지만 그렇지 않다면 부모가 다르다.
		int root = findParent(2);
		for(int i =3; i<numbering; i++) {
			if(root!=findParent(i)) {
				answer = -1;
				break;
			}
		}
	
		System.out.println(answer);
	}

	private static int kruskal() {
		int result =0;
		for(Node node : graph) {
			if(findParent(node.x) != findParent(node.y)) {
				union(node.x,node.y);
				result+=node.cost;
			}
		}
		return result;
	}

	private static void union(int x, int y) {
		x=findParent(x);
		y=findParent(y);
		
		if(x>y) parent[x]=y;
		if(x<y) parent[y]=x;
	}

	private static int findParent(int x) {
		if(parent[x] == x) return x;
		return parent[x] = findParent(parent[x]);
	}

	private static void makeBridge(int startX, int startY) {
		for (int i = 0; i < 4; i++) {
			int nx = startX;
			int ny = startY;
			int cost = 0;

			while (true) {
				nx += dx[i];
				ny += dy[i];

				if (nx < 0 || ny < 0 || nx >= n || ny >= m || map[nx][ny] == map[startX][startY])
					break;
				if (map[nx][ny] != 0 && map[nx][ny] != map[startX][startY]) {
					if (cost > 1)
						graph.add(new Node(map[startX][startY], map[nx][ny], cost));
					break;
				}

				cost++; // 도착지점은 카운트하지않음
			}
		}

	}

	public static void partition(int startX, int startY, int numbering) {
		Queue<Node> q = new LinkedList<>();
		boolean[][] v = new boolean[n][m];

		q.offer(new Node(startX, startY, 0));
		v[startX][startY] = true;
		map[startX][startY] = numbering;

		while (!q.isEmpty()) {
			Node node = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];

				if (nx < 0 || ny < 0 || nx >= n || ny >= m)
					continue;

				if (!v[nx][ny] && map[nx][ny] != 0) {
					v[nx][ny] = true;
					map[nx][ny] = numbering;
					q.offer(new Node(nx, ny, 0));
				}
			}
		}

	}

	static class Node {
		int x, y, cost;

		public Node(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}

	}
}
