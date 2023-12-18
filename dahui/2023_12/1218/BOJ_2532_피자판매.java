package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2532_피자판매 {
	static int size, m, n, ans;
	static int[] p1, p2;//피자 사이즈
	static int[] sum1 = new int[1000001];
	static int[] sum2 = new int[1000001];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		size = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		p1 = new int[2*m-1];
		p2 = new int[2*n-1];
		int s1 = 0;
		
		for(int i=0; i<m; i++) {
			p1[i] = Integer.parseInt(br.readLine());
			s1 += p1[i];
		}
		sum1[s1] = 1;
		
		
		for(int i=0; i<m-1; i++) {
			p1[m+i] = p1[i];
		}
		
		int s2 = 0;
		
		for(int i=0; i<n; i++) {
			p2[i] = Integer.parseInt(br.readLine());
			s2 += p2[i];
		}
		sum2[s2] = 1;

		for(int i=0; i<n-1; i++) {
			p2[n+i] = p2[i];
		}
		
		for(int i=0; i<m; i++) {
			int sum = 0;
			for(int j=0; j<m-1; j++) {
				sum += p1[i+j];
				sum1[sum]++;
			}
		}
		
		for(int i=0; i<n; i++) {
			int sum = 0;
			for(int j=0; j<n-1; j++) {
				sum += p2[i+j];
				sum2[sum]++;
			}
		}
		
		for(int i=1; i<size; i++)	{
			ans += (sum1[i] * sum2[size-i]);
		}
		
		ans += sum1[size];
		ans += sum2[size];
		
		System.out.println(ans);
		
	}

}
