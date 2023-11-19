package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_20920_영단어암기는괴로워 {
	static int N,M;
	static HashMap<String, Integer> map = new HashMap<>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			
			if(str.length() < M) continue;
			
			if(map.containsKey(str)) {
				map.put(str, map.get(str)+1);
			}else map.put(str, 1);
		}
		
		List<String> keyList = new ArrayList<>(map.keySet());
		Collections.sort(keyList, (o1, o2) -> 
			map.get(o2) - map.get(o1) == 0 ? 
					(o2.length() - o1.length() == 0 ? 
					o1.compareTo(o2) : o2.length() - o1.length()) :
					map.get(o2) - map.get(o1));
		
		for (String str : keyList) {
			sb.append(str).append("\n");
		}
		
		System.out.println(sb);
		
		
	}
	
}
