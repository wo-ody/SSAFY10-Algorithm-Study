package algorithm2023.jul.day23;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class S4_BOJ9372 {
	static int N, M;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		//테스트 케이스 T 개수만큼 반복
		for(int t = 1;t<=T;t++) {
			String[] s = br.readLine().split(" ");
			//나라의 개수 N과 비행기의 종류M
			N = Integer.parseInt(s[0]);
			M = Integer.parseInt(s[1]);
			for(int m = 0;m<M;m++) {
				s = br.readLine().split(" ");
			}
			sb.append((N-1)+"\n");
		}
		System.out.println(sb);
	}
}
