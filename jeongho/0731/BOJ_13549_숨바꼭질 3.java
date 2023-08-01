package algorithm2023.jul.day31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class G5_BOJ13549 {

	static int N, K;

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		K = Integer.parseInt(s[1]);
		boolean[] v = new boolean[100001];
		PriorityQueue<idx> q = new PriorityQueue<>((o1,o2)->{
			return o1.time-o2.time;
		});
		
		q.add(new idx(N, 0));
		v[N] = true;
		while(!q.isEmpty()) {
			idx cur = q.poll();
			v[cur.pos]=true;
			if(cur.pos==K) {
				System.out.println(cur.time);
				break;
			}
			if(isValid(cur.pos-1)&&!v[cur.pos-1]) {
				q.offer(new idx(cur.pos-1, cur.time+1));
			}
			if(isValid(cur.pos+1)&&!v[cur.pos+1]) {
				q.offer(new idx(cur.pos+1, cur.time+1));
			}
			if(isValid(cur.pos*2)&&!v[cur.pos*2]) {
				q.offer(new idx(cur.pos*2, cur.time));
			}
		}
		
		
 	}
	
	static boolean isValid(int n) {
		if(n<0||n>100000) {
			return false;
		}return true;
	}

	static class idx {
		int pos;
		int time;

		public idx(int pos, int time) {
			super();
			this.pos = pos;
			this.time = time;
		}
	}
}
