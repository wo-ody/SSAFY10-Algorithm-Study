package bj.S2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_22233_가희와키워드 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
		HashSet<String> hm = new HashSet<String>();
		// Set을 이용하여 키워드 사용 유무를 판단
		for (int i = 0; i < n; i++)
			hm.add(br.readLine());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), ","); // 사용한 키워드를 ,로 분리하여 사용했는지 판단
			while (st.hasMoreTokens()) { // 모든 키워드를 사용
				String key = st.nextToken();
				if (hm.contains(key)) // 만약 사용한 키워드가 Set에 있다면 삭제
					hm.remove(key);
			}
			sb.append(hm.size() + "\n"); // 사용하지 않은 키워드의 갯수를 출력
		}
		System.out.println(sb.toString());
	}
}
