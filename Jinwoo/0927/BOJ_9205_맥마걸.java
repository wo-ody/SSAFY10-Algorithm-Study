import java.util.*;
import java.io.*;
public class Main {
	static int[] root;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine()), n, point[][];
		boolean[] visit;
		
		for (int tc=0; tc<T; tc++) {
			n = Integer.parseInt(br.readLine());
			point = new int[n+2][2]; root = new int[n+2]; visit = new boolean[n+2];
			for (int i=0; i<n+2; i++) {
				st = new StringTokenizer(br.readLine());
				point[i][0] = Integer.parseInt(st.nextToken());
				point[i][1] = Integer.parseInt(st.nextToken());
				root[i] = i;
			}
			
			Deque<Integer> q = new ArrayDeque<>();
			q.add(0);
			visit[0] = true;
			int now;
			while(!q.isEmpty()) {
				now = q.poll();
				for (int i=0; i<n+2; i++) {
					if (visit[i]) continue;
					if (Math.abs(point[now][0] - point[i][0]) + Math.abs(point[now][1] - point[i][1])<=1000) {
						q.add(i);
						visit[i] = true;
					}
				}
			}
			sb.append((visit[n+1]) ? "happy\n":"sad\n");
		}
		System.out.println(sb);
	}

}
