import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static int n,k;
	static int map[][];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		map = new int[2][n];
		for (int i = 0; i < 2; i++) {
			String str=sc.next();
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.valueOf(str.charAt(j)-'0');
			}
		}
		if(go()) {
			System.out.println(1);
		}else
			System.out.println(0);
	}
	
	static boolean go() {
		boolean visit[][] = new boolean[2][n];
		int dc[] = {-1,1,k};
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {0,0,0});
		visit[0][0]=true;
		while(!q.isEmpty()) {
			int cur[]= q.poll();
			for (int i = 0; i < 3; i++) {
				int nc = cur[1]+dc[i];
				int nr = cur[0];
				int time = cur[2];
				if(i==2) {
					if(cur[0]==1)
							nr = 0;
						else
							nr = 1;
				}
				if(nc>=n) 
					return true;
				if(nc <= time) continue;
				if(visit[nr][nc]) continue;
				if(map[nr][nc]==0) continue;
				visit[nr][nc]=true;
				q.add(new int[] {nr,nc,time+1});
			}
		}
		return false;
	}
}
