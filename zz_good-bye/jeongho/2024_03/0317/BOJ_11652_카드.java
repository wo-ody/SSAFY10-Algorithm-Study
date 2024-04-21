package algorithm2024.mar.day17;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_11652_카드 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());

		HashMap<Long, Integer> map = new HashMap<>();
		int max = 0;
		Long ans = Long.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			Long n = Long.parseLong(br.readLine());
			int cnt =map.getOrDefault(n,0)+1;
			map.put(n, cnt);
			if(cnt>=max) {
				if(cnt==max){
					ans = Math.min(ans,n);
				}else{
					ans = n;
				}
				max = cnt;
			}
		}
		System.out.println(ans);
	}
}
