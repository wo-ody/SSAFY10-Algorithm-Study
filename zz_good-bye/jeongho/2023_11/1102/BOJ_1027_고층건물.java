package algorithm2023.nov.day02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1027_고층건물 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, b[];

	public static void main(String[] args) throws Exception {

		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int ans = 0;
		b = new int[N];
		for (int i = 0; i < N; i++) {
			b[i] = Integer.parseInt(st.nextToken());
		}

		//각각의 건물에 대해
		for (int i = 0; i < N; i++) {
			int cnt = 0;
			double d = b[i]+1;
			//왼쪽으로 보면서 기울기 비교
			for (int j = i - 1; j >= 0; j--) {
				double nd = (double)(b[i] - b[j]) / (double)(i - j);
				if(nd<d) {
					cnt++;
					d = nd;
				}
			}
			d = -b[i]-1;
			//오른쪽으로 보면서 기울기 비교
			for (int j = i + 1; j < N; j++) {
				double nd = (double)(b[j] - b[i]) / (double)(j - i);
				if(nd>d) {
					cnt++;
					d = nd;
				}
			}
			ans = Math.max(ans, cnt);
		}
		System.out.println(ans);
	}
}
