import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int t, n, to, des[][], start[] = new int[2];// 테케,편의점 수 ,현재 갈 곳,편의점과 페스티벌 좌표,집 위치[0]=x,[1]=y
	static boolean visit[];

	public static void main(String[] args) throws Exception {
		t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			n = Integer.parseInt(br.readLine());
			des = new int[n + 1][2];// 편의점과 페스티벌의 위치
			visit = new boolean[n + 1];// 편의점과 페스티벌 방문 여부

			st = new StringTokenizer(br.readLine());
			start[0] = Integer.parseInt(st.nextToken());
			start[1] = Integer.parseInt(st.nextToken());// 집의 위치

			for (int j = 0; j < n + 1; j++) {
				st = new StringTokenizer(br.readLine());
				des[j][0] = Integer.parseInt(st.nextToken());
				des[j][1] = Integer.parseInt(st.nextToken());

			}//편의점과 페스티벌의 위치
			bfs();
		}

	}

	static void bfs() {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(start);
		while (!queue.isEmpty()) {
			if (visit[n]) {//페스티벌에 도착한다면
				System.out.println("happy");
				return;
			}
			int[] cur = queue.poll();
			for (int i = 0; i < n + 1; i++) {
				if (!visit[i]) {
					int dis = Math.abs(des[i][0] - cur[0]) + Math.abs(des[i][1] - cur[1]);
					if (dis <= 1000) {//맥주 1박스로 갈 수 있는 최대 거리
						visit[i] = true;
						queue.add(new int[] { des[i][0], des[i][1] });
					}
				}
			}
		}
		System.out.println("sad");//bfs를 돌았지만 페스티벌에 도착하지 못한 경우
	}

}
