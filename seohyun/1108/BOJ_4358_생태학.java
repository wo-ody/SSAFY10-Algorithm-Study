package BOJ;

import java.io.*;
import java.util.*;

public class boj_4358_생태학 {
	static HashMap<String, Integer> hmap = new HashMap<>();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int total = 0;
		
		while(true) {
			String str = br.readLine();
			
			if(str == null) break;
			
			if(hmap.containsKey(str)) {
				int cnt = hmap.get(str);
				hmap.put(str, cnt + 1);
			}
			else {
				hmap.put(str, 1);
			}
			total++;
		}
		
		
		// 오름차순으로 출력
		ArrayList<Node> arr = new ArrayList<>();
		for(String str : hmap.keySet()) {
			int cnt = hmap.get(str);
			arr.add(new Node(str, cnt));
		}
		
		Collections.sort(arr, (o1,o2)-> o1.str.compareTo(o2.str));
		
		for(int i = 0; i < arr.size(); i++) {
			Node cur = arr.get(i);
			System.out.print(cur.str + " " );
			System.out.printf("%.4f", (cur.per / total) * 100);
			System.out.println();
		}
		
	}
	
	static class Node{
		String str;
		double per;
		
		Node(String str, double per){
			this.str = str;
			this.per = per;
		}
	}

}
