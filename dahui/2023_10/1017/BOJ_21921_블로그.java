package alone;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_21921_블로그 {
	static int N,X,visit,day;
	static int[] blog;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		blog = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			blog[i] = Integer.parseInt(st.nextToken());
		}
		
		Queue<Integer> q = new ArrayDeque<>();
		int sum = 0;
		
		for(int i=0; i<X; i++) {
			q.add(blog[i]);
			sum += blog[i];
		}
		visit = sum;
		day++;
		
		for(int i=X; i<N; i++) {
			sum -= q.poll();
			q.add(blog[i]);
			sum += blog[i];
			
			if(sum > visit) {
				day = 1;
				visit = sum;
			}else if(sum == visit) {
				day++;
			}
		}
		
		if(visit == 0)System.out.println("SAD");
		else {System.out.println(visit);
		System.out.println(day);}
	}

}
