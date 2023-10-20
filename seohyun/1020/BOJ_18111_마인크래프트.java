package BOJ;

import java.io.*;
import java.util.*;

public class boj_18111_마인크래프트 {

	static int N,M,B;
	
	static HashMap<Integer, Integer> map;
	
	static int result_time, result_height;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		map = new HashMap<>();
		result_time = Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int su = Integer.parseInt(st.nextToken());
				if(map.containsKey(su)) {
					int cnt = map.get(su);
					map.put(su, cnt + 1);
				}
				else {
					map.put(su, 1);
				}
			}
		}
		
		simulation();
		System.out.println(result_time + " " + result_height);

	}
	
	static void simulation() {
		ArrayList<Node> arr = new ArrayList<>();
		for(int height : map.keySet()) {
			int cnt = map.get(height);
			arr.add(new Node(height,cnt));
		}
		
		Collections.sort(arr, (o1,o2) -> o2.height - o1.height);
		int minH = arr.get(arr.size() - 1).height;
		int maxH = arr.get(0).height;
		
		for (int h = minH; h <= maxH; h++) {
			int time = 0;
			int tmpB = B;
			for(Node cur : arr) {
				if(cur.height > h) {
					int diff = cur.height - h;
					time += (2*diff*cur.cnt);
					tmpB += (diff*cur.cnt);
				}
				else if(cur.height < h) {
					int diff = h - cur.height;
					time += (diff*cur.cnt);
					tmpB -= (diff*cur.cnt);
				}
			}
			// tmpB 가 0 이상이면 정답 갱신
			if(tmpB < 0) continue;
			
			if(result_time >= time) {
				result_time = Math.min(result_time, time);
				result_height = h;
			}
			
		}
		
		
	}
	
	static class Node{
		int height, cnt;

		public Node(int height, int cnt) {
			super();
			this.height = height;
			this.cnt = cnt;
		}
		
	}

}
