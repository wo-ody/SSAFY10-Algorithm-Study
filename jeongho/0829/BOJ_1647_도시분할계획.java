package algorithm2023.aug.day29;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

//보글보글 타자감
//키보드 이뿌다 정호얌
//멋쨍이 정호
//존잘 정호
//정호 팬클럽 1호
//아니ㅣㅣㅣ가격도 괜찮네 
//나도살래나도살래나도살래나도살래나도살래 ㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎ우왕아아아아진짜 대박
//고마워 잘쓸께 ~~~
//안줘도 되는데 

public class BOJ_1647_도시분할계획 {
	static int N, M;
	static int[] parent;

	static void init(int n) {
		parent = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			parent[i] = i;
		}
	}

	static int find(int x) {
		if (parent[x] == x)
			return x;

		return parent[x] = find(parent[x]);
	}

	static boolean union(int x, int y) {
		int px = find(x);
		int py = find(y);

		if (px == py)
			return false;

		parent[px] = py;
		return true;
	}

	static ArrayList<Edge> edge = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		init(N);
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			edge.add(new Edge(a, b, c));
		}

		Collections.sort(edge, (o1, o2) -> o1.cost - o2.cost);
		int sum = 0;
		ArrayList<Integer> ans = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			Edge cur = edge.get(i);
			if (union(cur.a, cur.b))
				ans.add(cur.cost);
		}
		for(int i =0;i<ans.size()-1;i++) {
			sum+=ans.get(i);
		}

		System.out.println(sum);

	}

	static class Edge {
		int a;
		int b;
		int cost;

		public Edge(int a, int b, int cost) {
			this.a = a;
			this.b = b;
			this.cost = cost;
		}

	}
}
