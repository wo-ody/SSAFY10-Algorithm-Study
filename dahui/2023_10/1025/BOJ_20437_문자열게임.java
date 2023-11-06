package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
//acaccbad
public class BOJ_문자열게임2 {
	static int T, K;
	static String W;
	static ArrayList<ArrayList<Integer>> alphaIdx; //abcde fghij klmno pqrst uvwxy z 인덱스
	static StringBuilder sb = new StringBuilder();
	static int ans1, ans2;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			W = br.readLine();
			K = Integer.parseInt(br.readLine());
			alphaIdx = new ArrayList<>();
			ans1 = Integer.MAX_VALUE;
			ans2 = 0;
			
			for(int j=0; j<26; j++) {
				alphaIdx.add(new ArrayList<>());
			}
			
			boolean flag = false;
			
			for(int j=0; j<W.length(); j++) {
				char c = W.charAt(j);
				int idx = (int)c - 'a';
				alphaIdx.get(idx).add(j);
				
				if(alphaIdx.get(idx).size()==K) {
					flag = true;
					int length = j - alphaIdx.get(idx).get(0) + 1;
					ans1 = Math.min(ans1, length);
					ans2 = Math.max(ans2, length);
					alphaIdx.get(idx).remove(0);
				}
				
			}
			
			if(flag) {
				sb.append(ans1).append(" ").append(ans2).append("\n");
			}else {
				sb.append(-1).append("\n");
			}
			
		}
		System.out.println(sb);

	}

}
