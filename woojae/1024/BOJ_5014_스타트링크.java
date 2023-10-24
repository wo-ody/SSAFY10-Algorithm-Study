package practice.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_5014 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int f, s, g, u, d;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		f = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		g = Integer.parseInt(st.nextToken());
		u = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		arr = new int[f+1];
		
		solve();

	}
	
	static void solve() {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(s);
		int current = 0;
		
		while(!q.isEmpty()) {
			current = q.poll();
			
			if(current == g) {
				System.out.println(arr[current]);
				break;
			}
			for (int next : new int[] {current + u, current - d}) {
				if(next == s)  // 츨발층에선 버튼을 누를 필요가 없으므로 0이지만 0은 방문 하지 않음을 나타내기 때문에 이를 탐색 범위에서 제외해야 한다.
					continue;  // 이를 처리하지 않으면 출발층이 next로 큐에 들어오며 값이 바뀌게 된다. ex) 5 5 1 0 1
				if(1 <= next && next <= f && arr[next] == 0) {  // 누른 횟수(방문 여부)를 확인하지 않으면 해당 층을 갈 때마다 값이 누적됨
					arr[next] = arr[current] + 1;  // 이전 층에서 누른 횟수
					q.offer(next);
				}
			}
		}
		if(current != g)  // 목표 층에 도달하지 못한 경우
			System.out.println("use the stairs");
	}
}
