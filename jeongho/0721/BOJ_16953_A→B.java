package jul_2023;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class S2_BOJ16953_0721 {
	
	static int A;
	static int B;
	static long ans = -1;
	
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("C:\\SSAFY\\SSAFY_LIVE\\Algorithm\\Baekjoon\\src\\input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		A = Integer.parseInt(s[0]);
		B = Integer.parseInt(s[1]);
		Queue<pair> q = new LinkedList<>();
		q.add(new pair(A, 1));
		while(!q.isEmpty()) {
			pair cur =q.poll();
			if(cur.n==B) {
				ans = cur.cnt;
				break;
			}
			
			if(cur.n*2<=B) {
				q.add(new pair(cur.n*2, cur.cnt+1));
			}
			if(cur.n*10+1<=B) {
				q.add(new pair(cur.n*10+1, cur.cnt+1));
			}
		}
		System.out.println(ans);
		
		
	}
}

class pair{
	long n;
	long cnt;
	public pair(long n , long cnt) {
		this.n = n;
		this.cnt = cnt;
	}
}
