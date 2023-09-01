package algorithm2023.aug.day31;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1456_거의소수 {
	static long A, B;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		A = Long.parseLong(st.nextToken());
		B = Long.parseLong(st.nextToken());

		double a = Math.sqrt(A);
		double b = Math.sqrt(B);

		boolean[] era = new boolean[((int) Math.ceil(b))+1];
		for (int i = 2; i <= b; i++) {
			if (!era[i]) {
				for (double j = (double)i * i; j <= b; j += i) {
					era[(int)j] = true;
				}
			}
		}

		int cnt = 0;

		for (int i = 2; i <= b; i++) {
			//소수면
			if (!era[i]) {
				//i의 2승부터 B까지 다 더하기
				for (double j = (double)i * (double)i; j <= B; j *= i) {
					if(j<0)break;
					if(j>=A&&j<=B) {
						cnt++;
					}
					
				}
			}

		}
		System.out.println(cnt);

	}
}
