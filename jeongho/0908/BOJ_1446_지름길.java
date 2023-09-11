package algorithm2023.sep.day07;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1446_지름길 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static ArrayList<ArrayList<Path>> path = new ArrayList<>();
	
	static int N, D, road[];

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		road = new int[D+1];
		for(int i =0;i<=D;i++) {
			path.add(new ArrayList<>());
		}
		
		for(int i =0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			if(e>D||e-s<d)continue;
			path.get(e).add(new Path(s,d));
		}
		Arrays.fill(road, Integer.MAX_VALUE);
		road[0] = 0;
		for(int i =1 ;i<=D;i++) {
			if(path.get(i).size()>0) {
				for(Path p : path.get(i)) {
					if(road[p.s]+p.d>road[i])continue;
					road[i] = Math.min(road[i-1]+1, road[p.s]+p.d);
				}
			}else {
				road[i] = road[i-1]+1;
			}
		
		}
		System.out.println(road[D]);
	}
	
	static class Path{
		int s;
		int d;
		public Path( int s, int d) {
			this.s =s;
			this.d = d;
		}
		
		
	}
}
