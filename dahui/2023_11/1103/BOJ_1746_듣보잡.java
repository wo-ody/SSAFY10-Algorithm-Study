package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_1746_듣보잡 {
	static int N,M;
	static HashSet<String> set = new HashSet<>();
	static ArrayList<String> ans = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }
		
		for (int i = 0; i < M; i++) {
            String str = br.readLine();
            if(set.contains(str)){
                ans.add(str);
            }
        }
		
		 Collections.sort(ans);
		 
		 sb.append(ans.size()).append("\n");
		 for (String str : ans) {
			sb.append(str).append("\n");
		}
		 
		 System.out.println(sb);

	}

}
