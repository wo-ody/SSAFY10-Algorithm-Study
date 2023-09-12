/*
 *  09.12 김창희
 *  BOJ_27945_슬슬가지를먹지않으면죽는다
 *
 *  [풀이]
 *  1. cost(문제에서 t)순으로 정렬을 한 후 크루스칼을 진행한다
 *  2. 다음 날짜가 아니거나, 모든 경로가 이어졌다면 함수종료
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static PriorityQueue<Node> q= new PriorityQueue<>((o1,o2)->Integer.compare(o1.cost, o2.cost));
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		parent = new int[n + 1];
		for (int i = 1; i < n + 1; i++) parent[i] = i;

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			q.offer(new Node(x, y, cost));
		}

		int answer = kruskal();
		System.out.println(answer);

	}

	public static int kruskal() {
		int day = 0;
		while (!q.isEmpty()) {
			Node node = q.poll();
			if (day == node.cost) continue;
			if(day+1<node.cost) break;
			if (findParent(node.x) != findParent(node.y)) {
				union(node.x, node.y);
				day++;
			}else {
				break;
			}
		}
		return day+1;
	}

	public static void union(int x, int y) {
		x = findParent(x);
		y = findParent(y);

		if (x != y) parent[x] = y;
	}

	public static int findParent(int x) {
		if (parent[x] == x) return x;
		return parent[x] = findParent(parent[x]);
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
