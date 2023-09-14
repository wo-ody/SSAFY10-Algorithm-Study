package bj.S2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 처음에는 bfs를 생각했다가 알고보니 역방향 탐색으로 풀면 되는 문제
 * 뒤에서부터 max 값으로 설정해두고 역방향 탐색으로 더 큰 값이 나올때까지 반복
 * 더 큰 값이 나오면 max를 다시 갱신해주고 그 외에는 팔아주면 됨
 */
public class BOJ_11501_주식 {
	static int T, N, max;
	static int[] money; // 주가 정보
	static long answer; // long으로 선언해줘야 함 -> 부호있는 64bit 정수형으로 답 표현 가능
	// int는 32bit까지 표현가능
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			answer = 0;
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			money = new int[N];
			
			for (int i = 0; i < N; i++) {
				money[i] = Integer.parseInt(st.nextToken());
			}
			
			// 최댓값을 맨 뒤에 있는 값으로 잡고
			max = money[N - 1];
			for (int i = N - 2; i >= 0; i--) {
				if (max < money[i]) {
					max = money[i];
				} else {
					answer += max - money[i];
				}
			}
			
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}
}
