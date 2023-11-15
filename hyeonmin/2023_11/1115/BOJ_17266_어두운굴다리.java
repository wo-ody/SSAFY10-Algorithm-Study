package month11.day15;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17266_어두운굴다리 {
	
	static int N, M, right, left, max;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 0 ~ x1 ~ x2 ~ N
		// 각 구간의 길이를 구한다.
		// 양 끝을 제외한 구간길이는 절반으로 나눈다.
		// 홀수이면? 올림     4-1=3  2
		
		left = 0;
		right = Integer.parseInt(st.nextToken());
		
		// 0에서 첫번째 가로등 구간
		max = right - left;
		
		// 양끝제외 max 값 탐색(절반), (right-left+1)/2 >> 홀수 보정
		for (int i = 1; i < M; i++) {
			right = Integer.parseInt(st.nextToken());
			max = Math.max(max, (right-left+1)/2);
			left = right;
		}
		
		// 마지막 가로등에서 N까지의 구간
		max = Math.max(max, N - left);
		
		System.out.println(max);
	}
}
