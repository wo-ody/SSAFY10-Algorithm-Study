package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1027_고층건물 {
	static int N,ans;
	static int[] h;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		h = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			h[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<N; i++) {
			int cnt = 0;
			cnt += left(i); //왼쪽에서 보이는 건물들
			cnt += right(i); //오른쪽에서 보이는 건물들
			
			ans = Math.max(cnt, ans);
		}
		
		System.out.println(ans);

	}
	
	static int left(int idx) {
		int c = 0;
		//기울기가 왼쪽으로 갈수록 작아져야 한다. 
		double gradient = Integer.MAX_VALUE;
		for(int i=idx-1; i>=0; i--) {
			double g = (double)(h[idx] - h[i])/(double)(idx - i); //y좌표 차 / x좌표 차
			
			if(g < gradient) {
				c++;
				gradient = g;
			}
		}
		
		return c;
	}
	
	static int right(int idx) {
		int c = 0;
		//기울기가 오른쪽으로 갈수록 커야 보인다.
		double gradient = Integer.MIN_VALUE;
		for(int i=idx+1; i<N; i++) {
			double g = (double)(h[i] - h[idx])/(double)(i-idx); //y좌표 차 / x좌표 차
			
			if(g > gradient) {
				c++;
				gradient = g;
			}
		}
		return c;
	}

}
