package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class BOJ_1302_베스트셀러 {
	static int N;
	static HashMap<String, Integer> map = new HashMap<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			
			if(map.containsKey(str)) {
				int cnt = map.get(str);
				map.put(str, cnt+1);
			}else {
				map.put(str, 1);
			}
		}
		
		List<String> keySet = new ArrayList<>(map.keySet());

        // Value 값으로 오름차순 정렬
        keySet.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
               if(map.get(o2).compareTo(map.get(o1))==0) {
            	   return o1.compareTo(o2);
               }else return map.get(o2).compareTo(map.get(o1));
            }
        });
        
        System.out.println(keySet.get(0));
		
	}

}
