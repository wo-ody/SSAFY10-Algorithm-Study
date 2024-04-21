package algorithm2023.dec.day11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_11558_TheGameOfDeath {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static ArrayList<Integer> adjList = new ArrayList<>();
	static int ans;
	static int N;
	static boolean[] v;
	
	public static void main(String[] args) throws Exception{
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 0;t<T;t++) {
			ans = 0;
			N = Integer.parseInt(br.readLine());
			v= new boolean[N+1];
			adjList.add(0);
			
			for(int i =0 ;i<N;i++) {
				adjList.add(Integer.parseInt(br.readLine()));
			}
			tgod(1,1);
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}
	
	static void tgod(int i, int cnt) {
		if(adjList.get(i)==N) {
			ans = cnt;
			return;
		}
		if(v[i])return;
		v[i] = true;
		tgod(adjList.get(i), cnt+1);
	}
}
