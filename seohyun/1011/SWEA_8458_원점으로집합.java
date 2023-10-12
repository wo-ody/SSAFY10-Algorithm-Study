package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class swea_8458_원점으로집합 {
	static int T,N;
	static ArrayList<Node> map;
	
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new ArrayList<>();
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map.add(new Node(x,y));
			}
			
			if(check()) {
				sb.append("#").append(tc).append(" ").append(simulation()).append("\n");
			}
			else {
				sb.append("#").append(tc).append(" ").append("-1").append("\n");
			}
		}
		System.out.println(sb);
		
		
	}
	
	static boolean check() {
		
		boolean isEven = false;
		if((Math.abs(map.get(0).x) + Math.abs(map.get(0).y)) % 2 == 0 ) isEven = true;
		
		if(isEven) {
			for (int i = 1; i < map.size(); i++) {
				Node cur = map.get(i);
				if((Math.abs(cur.x) + Math.abs(cur.y)) % 2 != 0) {
					return false;
				}
			}
		}
		else {
			for (int i = 1; i < map.size(); i++) {
				Node cur = map.get(i);
				if((Math.abs(cur.x) + Math.abs(cur.y)) % 2 == 0) {
					return false;
				}
			}
		}
		return true;
	}
	
	static int simulation() {
		int result = Integer.MIN_VALUE;
		
		for(Node cur : map) {
			int target = Math.abs(cur.x) + Math.abs(cur.y);
			
			int other = 0;
			for (int i = 0; ; i++) {
				other += i;
				if(other >= target) {
					if( (target + other ) % 2 == 0 ) {
						result = Math.max(result, i);
						break;
					}
				}
			}
		}
		
		return result;
	}
	
	static class Node{
		int x,y;
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

}
