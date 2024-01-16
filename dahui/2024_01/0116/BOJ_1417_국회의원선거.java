package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_1417_국회의원선거 {
	static int N, dasom;
	static PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> 
	o2 - o1);
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dasom = Integer.parseInt(br.readLine());
		
		if(N==1) System.out.println(0);
		else {
			for(int i=0; i<N-1; i++) {
				pq.add(Integer.parseInt(br.readLine()));
			}
			
			int ans = 0;
			
			while(true) {
				int num = pq.poll();
				if(dasom > num) break;
				
				dasom++;
				num--;
				ans++;
				pq.add(num);
			}
			
			System.out.println(ans);
		}
		
		
		

	}

}
