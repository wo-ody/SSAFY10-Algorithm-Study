import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n;
	static double x, y;
	static Node[] star;
	static List<Edge> grapgh;
	static int[] parents;
	static double min_cost;
	static double answer;
	
	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		star = new Node[n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			x = Double.parseDouble(st.nextToken());
			y = Double.parseDouble(st.nextToken());
			star[i] = new Node(x, y);  // 몇 번째 노드인지와 함께 좌표 저장
		}
		grapgh = new ArrayList<Edge>();  // 간선 정보를 저장하는 그래프
		for(int i = 0; i < n; i++) {
			for(int j = i + 1; j < n; j++) {
				double cost = Math.sqrt(Math.pow(star[j].x - star[i].x, 2) + Math.pow(star[j].y - star[i].y, 2));  // 좌표의 거리
				grapgh.add(new Edge(i, j, cost));
			}
		}
		parents = new int[n + 1];
		for(int i = 1; i <= n; i++)
			parents[i] = i;
		min_cost = Double.MAX_VALUE;
		answer = 0;
		
		Collections.sort(grapgh);
		
		for (Edge e : grapgh) {
			if(union(e.from, e.to)) {
				answer += e.cost;
				min_cost = Math.min(min_cost, e.cost);
			}
		}
		System.out.println(answer);

	}
	
	static int find(int x) {
		if(parents[x] == x)
			return x;
		return parents[x] = find(parents[x]);
	}
	
	static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x == y)
			return false;
		parents[y] = x;
		return true;
	}
	
	static class Node {
		double x, y;
		Node(double x, double y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static class Edge implements Comparable<Edge>{  // 크루스칼 알고리즘 적용을 위한 실수 정렬 오버라이딩
		int from, to;
		double cost;
		Edge(int from, int to, double cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
		@Override
		public int compareTo(Edge o) {
			return this.cost < o.cost ? -1 : 1 ;
		}
		
	}

}