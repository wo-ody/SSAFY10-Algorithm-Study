package alone;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_14630_변신로봇 {
	static int N,ans,start,end;
	static String[] str;
	static int[][] arr;
	static int[][] adjArr;
	static boolean[] visit;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		str = new String[N];
		for(int i=0; i<N; i++) {
			str[i] = br.readLine();
		}
		
		int l = str[0].length();
		arr = new int[N+1][l];
		for(int i=0; i<N; i++) {
			for(int j=0; j<l; j++) {
				arr[i+1][j] = str[i].charAt(j)-'0';
			}
		}
		
		adjArr = new int[N+1][N+1];
	
		StringTokenizer st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				int diff = 0;
				for(int k=0; k<l; k++) {
					diff += (arr[i][k] - arr[j][k])*(arr[i][k] - arr[j][k]);
				}
				adjArr[i][j] = diff;
			}
		}
		
		visit = new boolean[N+1];
		dijk(start, end);
		System.out.println(ans);
	}
	
	static void dijk(int start, int end) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)-> o1[1] - o2[1] );
		
		pq.add(new int[] {start, 0});
		visit[start] = true;
		
		while(!pq.isEmpty()) {
			int[] a = pq.poll();
			int b = a[0];
			visit[b] = true;
			
			if(b == end) {
				ans = a[1];
				return;
			}
			
			for(int i=1; i<=N; i++) {
				if(!visit[i]) {
					pq.add(new int[] {i, adjArr[b][i] + a[1]});
				}
			}
		}
		
	}
}
