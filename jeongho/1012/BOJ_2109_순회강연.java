package algorithm2023.oct.day12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_2109_순회강연 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->o2-o1);
	static ArrayList<ArrayList<Integer>> lec = new ArrayList<>();
	static int n;


	public static void main(String[] args) throws Exception {
		n = Integer.parseInt(br.readLine());
		
		int maxD = 0;
		
		for(int i =0 ;i<=10000;i++) {
			lec.add(new ArrayList<>());
		}

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

			maxD = Math.max(maxD, d);
			lec.get(d).add(p);
			
		}
		int sum = 0;
		
		for(int i= 10000;i>0;i--) {
			for(int n : lec.get(i)) {
				pq.add(n);
			}
			if(!pq.isEmpty()) {
				sum+=pq.poll();
			}
		}
		
		System.out.println(sum);

	}
}
