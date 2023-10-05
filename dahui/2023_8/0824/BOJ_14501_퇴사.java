package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_14501_퇴사 {
	static consulting[] con;
	static int N,sum,max;
	static List<consulting> tgt = new ArrayList<>();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		con = new consulting[N];
		
		for(int i=0 ;i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = i+1;
			int e = Integer.parseInt(st.nextToken()) + i;
			int p = Integer.parseInt(st.nextToken());
			
			con[i] = new consulting(s,e,p);
		}
		
//		for (consulting c : con) {
//			System.out.println(c.start + " " + c.end + " " + c.p);
//		}
		
		simulation(0,0);
		
		System.out.println(max);
	}
	
	static void simulation(int srcIdx, int day) {
		//기저조건
		if(srcIdx == N) {
			for (consulting c : tgt) {
				sum += c.p;
			}
			max = Math.max(max, sum);
			sum = 0;
			if(tgt.size() != 0) tgt.remove(tgt.size()-1); //채우기 전으로 돌아가기
			return;
		}
		
		if(con[srcIdx].start > day && con[srcIdx].end <= N) {
			tgt.add(con[srcIdx]);
			simulation(srcIdx + 1, con[srcIdx].end);
		}
		simulation(srcIdx + 1, day);
	}
	
	static class consulting{
		int start,end,p; //시작날, 끝날, 금액
		
		public consulting(int start, int end, int p) {
			this.start = start;
			this.end = end;
			this.p = p;
		}
	}
}
