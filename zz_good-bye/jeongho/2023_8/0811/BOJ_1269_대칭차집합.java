package algorithm2023.aug.day11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_1269_대칭차집합 {
	static int AN, BN;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		AN = Integer.parseInt(st.nextToken());
		BN = Integer.parseInt(st.nextToken());
		Map<Integer,Boolean> map = new HashMap<>();
		int a = 0;
		int b= 0;
		int dup = 0;
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < AN; i++) {
			map.put(Integer.parseInt(st.nextToken()), true);
		}
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < BN; i++) {
			int n = Integer.parseInt(st.nextToken());
			if(map.containsKey(n))dup++;
		}
		System.out.println(AN+BN-dup*2);
	}
}