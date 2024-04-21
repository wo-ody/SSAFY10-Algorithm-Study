package algorithm2024.mar.day17;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_2776_암기왕 {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			HashSet<Integer> set = new HashSet<>();
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int n = 0; n < N; n++) {
				set.add(Integer.parseInt(st.nextToken()));

			}
			int M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < M; m++) {
				if(set.contains(Integer.parseInt(st.nextToken()))){
					sb.append("1");
				}else{
					sb.append("0");
				}
				sb.append("\n");
			};
		}
		System.out.println(sb);
	}
}
