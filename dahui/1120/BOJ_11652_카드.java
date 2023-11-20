package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class BOJ_11652_카드 {
	static HashMap<Long, Integer> map = new HashMap<>();
	static int N;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			long num = Long.parseLong(br.readLine());
			
			if(map.containsKey(num)) {
				int cnt = map.get(num);
				map.put(num, cnt+1);
			}else {
				map.put(num, 1);
			}
		}
		
		List<Long> keyList = new ArrayList<>(map.keySet());
		Collections.sort(keyList, (o1, o2) -> 
			map.get(o2) - map.get(o1) == 0 ?
			 o1.compareTo(o2) : map.get(o2) - map.get(o1)
		);
		
		System.out.println(keyList.get(0));

	}

}
