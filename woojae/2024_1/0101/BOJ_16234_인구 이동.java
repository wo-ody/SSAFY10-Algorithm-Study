import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] direction = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int n, l, r;
	static int[][] maps;
	static boolean[][] visit;
	static Queue<Country> q;
	static int answer;

	// 1. 국경선을 공유하는 두 나라의 인구수 차이가 l 이상 r이하
	// 2. 각 칸의 인구수 = 연합의 인구수 / 연합을 이루고 있는 칸의 개수
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		maps = new int[n][n];
		answer = 0;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++)
				maps[i][j] = Integer.parseInt(st.nextToken());
		}
		
		while(true) {
			visit = new boolean[n][n];
			int move = 0;  // 국경 검사할 때 마다 이동 횟수 초기화 
			
			for (int i = 0; i < n; i++)  // 한 번에 모든 국경 검사
				for (int j = 0; j < n; j++)
					if(!visit[i][j])
						move += bfs(new Country(i, j, maps[i][j]));  // 값을 토글식으로 저장하면 True더라도 마지막 False면 False이기 때문
			
			if(move == 0)  // 더 이상 이동이 일어나지 않았다면
				break;
			answer++;
		}

		System.out.println(answer);
	}

	static int bfs(Country node) {
		List<Country> union = new ArrayList<>();  // 연합국을 저장할 자료 구조
		q = new ArrayDeque<>();  // 노드 탐색을 위한 자료 구조
		int y = node.y, x = node.x, total_population = node.population;
		union.add(node);
		q.add(node);
		visit[y][x] = true;  // 주어진 노드를 기점으로 인접한 노드 탐색

		while (!q.isEmpty()) {
			Country i = q.poll();
			for (int[] d : direction) {
				int my = i.y + d[0];
				int mx = i.x + d[1];
				if (0 <= my && my < n && 0 <= mx && mx < n && !visit[my][mx]) {  // 유효 범위이며 아직 방문하지 않은 노드
					int diff = Math.abs(maps[i.y][i.x] - maps[my][mx]);
					if (l <= diff && diff <= r) {  // 국경 이동 조건을 만족한다면
						Country next = new Country(my, mx, maps[my][mx]);
						visit[my][mx] = true;
						union.add(next);  // 연합 국가에 추가
						q.add(next);
						total_population += next.population;
					}
				}
			}
		}

		if (union.size() > 1) {  // 인구 이동
			for (Country i: union)
				maps[i.y][i.x] = total_population / union.size();
			
			return 1;
		}
		
		return 0;
	}

	static class Country {  // 각 국가를 노드로 표현
		int y, x, population;

		Country(int y, int x, int population) {
			this.y = y;
			this.x = x;
			this.population = population;
		}
	}

}
