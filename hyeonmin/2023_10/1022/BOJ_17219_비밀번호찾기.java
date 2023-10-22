package month10.day22;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_17219_비밀번호찾기 {

	static int N, M;
	static HashMap<String, String> map = new HashMap<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			map.put(st.nextToken(), st.nextToken());
		}
		
		for (int j = 0; j < M; j++) {
			sb.append( map.get(br.readLine()) ).append("\n");
		}
		
		System.out.println(sb);
		
	}

}
