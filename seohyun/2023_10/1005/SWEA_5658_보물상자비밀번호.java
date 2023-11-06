package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class swea_5658_보물상자비밀번호 {
	static int T,N,K;
	static Deque<Character> dq;
	
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			char[] tmp = br.readLine().toCharArray();
			dq = new ArrayDeque<>();
			for(char c : tmp) dq.add(c);
			
			
			// 정답
			sb.append("#").append(tc).append(" ").append(simulation()).append("\n");
		}
		System.out.println(sb);
	}
	
	static int simulation() {
		Set<Integer> result = new HashSet<>();
		ArrayList<Integer> nums = new ArrayList<>();
		
		for (int i = 0; i < N/4; i++) {
			// 회전
			char last = dq.pollLast();
			dq.addFirst(last);
			
			// N개씩 끊어서 Set에 담기
			int cnt = 0;
			String s = "";
			for(char c : dq) {
				s += c;
				cnt++;
				if(cnt == N/4) {
					int num = Integer.parseInt(s,16);
					if(!result.contains(num)) nums.add(num);
					result.add(num);
					cnt = 0;
					s = "";
				}
			}
			
		}
		
		//정렬
		Collections.sort(nums,Collections.reverseOrder());
		
		return nums.get(K-1);
	}

}
