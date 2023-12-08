import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int T, N, M;
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			int num = (int) Math.pow(2, N) - 1;// 뒤의 N개의 비트가 1인 수
			if ((num & M) == num)// M의 마지막 N개의 비트를 num이랑 and연산을 통해 모두 1인지 확인했을 때 맞다면
				sb.append("#" + t + " " + "ON" + "\n");
			else// 조건을 만족시키지 못한다면
				sb.append("#" + t + " " + "OFF" + "\n");
		}
		System.out.println(sb);
	}
}