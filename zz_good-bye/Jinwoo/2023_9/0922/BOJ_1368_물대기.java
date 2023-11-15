 java.io.*;
import java.util.*;
public class Main {
	static boolean[] visit;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[] well = new int[n];
		for (int i=0; i<n; i++) {
			well[i] = Integer.parseInt(br.readLine());
		}
		
		int[][] mulgil = new int[n+1][n+1];
		for (int i=0; i<n; i++) {
			mulgil[n][i] = well[i]; mulgil[i][n] = well[i];
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<n; j++) 
				mulgil[i][j] = Integer.parseInt(st.nextToken());
		}
		
		PriorityQueue<int[]> heap = new PriorityQueue<>((o1, o2)-> o1[1]-o2[1]);
		visit = new boolean[n+1]; 
		heap.add(new int[] {n, 0});
		int cnt=0, ans=0; int[] now;
		while(!heap.isEmpty()) {
			now = heap.poll();
			if (visit[now[0]]) continue;
			visit[now[0]] = true;
			ans += now[1];
			cnt++; if (cnt==n+1) break;
			
			for (int i=0; i<=n; i++) {
				if (i==now[0] || visit[i]) continue;
				heap.add(new int[] {i, mulgil[now[0]][i]});
			}
		}
		System.out.println(ans);
	}

