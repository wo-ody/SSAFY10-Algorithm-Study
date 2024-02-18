package practice.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class boj_1351 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static long n;
    static int p, q;
    static HashMap<Long, Long> answer;
	
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Long.parseLong(st.nextToken());
		p = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		answer = new HashMap<Long, Long>();  // 제약조건이 워낙 크다보니 배열을 선언 할 수 없음
		answer.put(0L, 1L);
		solve(n);
		System.out.println(answer.get(n));
	}
	
	static long solve(long i) {
		if(answer.containsKey(i))
			return answer.get(i);
		answer.put(i, solve(i/p) + solve(i/q));
		return answer.get(i);
	}
}
