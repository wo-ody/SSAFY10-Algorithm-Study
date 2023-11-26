import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static int N,W,H;
	static int ans = Integer.MAX_VALUE;
	static int[][] map, copy;
	static boolean[][] visited;
	static boolean[] check;
	static int[] selected;
	static int[] dr = {};
	static int[] dc = {};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int  T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			N = sc.nextInt();
			W = sc.nextInt();
			H = sc.nextInt();
			
			map = new int[H][W];
			copy = new int[H][W];
			visited = new boolean[H][W];
			check = new boolean[W];
			selected = new int[N];
			ans = Integer.MAX_VALUE;
			
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					map[i][j] = sc.nextInt();
					copy[i][j] = map[i][j];
				}
			}
			
			perm(0);
			
			System.out.println("#"+tc+" "+ans);
		}
	}
	
	static void perm(int cnt) {
		if(cnt == N) {
			for(int b=0; b<N; b++) {
				destroy(selected[b]);

				for(int j=0; j<W; j++) { 
					int[] temp = new int[H];
					int idx = 0;

					for(int i=H-1; i>=0; i--) {
						if(map[i][j] != 0) {
							temp[idx++] = map[i][j];
						}
					}
					
					idx = 0;
					for(int i=0; i<H; i++) {
						map[i][j] = temp[H-1-i];
					}
				}
			}
			
			int block = 0; 
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					if(map[i][j] != 0)
						block++;
				}
			}
			
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					map[i][j] = copy[i][j];
				}
			}

			if(ans > block) {
				ans = block;
			}

			return;
		}
		
		for(int i=0; i<W; i++) {
			selected[cnt] = i;
			check[i] = true;
			perm(cnt+1);
			check[i] = false;
		}
	}
	
	static void destroy(int x) {
		Queue<Point> q = new LinkedList<>();
		
		for(int i=0; i<H; i++) {
			if(map[i][x] != 0) {
				q.add(new Point(i,x, map[i][x]));
				break;
			}
		}
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			int r = p.r;
			int c = p.c;
			
			//위
			for(int i=0; i<p.power; i++) {
				if(r-i>=0 && map[r-i][c] != 0) {
					q.add(new Point(r-i, c, map[r-i][c]));
					map[r-i][c] = 0;
				}
			}
			//아래
			for(int i=0; i<p.power; i++) {
				if(r+i<H && map[r+i][c] != 0) {
					q.add(new Point(r+i, c, map[r+i][c]));
					map[r+i][c] = 0;
				}
			}
			//왼쪽
			for(int i=0; i<p.power; i++) {
				if(c-i>=0 && map[r][c-i] != 0) {
					q.add(new Point(r, c-i, map[r][c-i]));
					map[r][c-i] = 0;
				}
			}
			//오른쪽
			for(int i=0; i<p.power; i++) {
				if(c+i<W && map[r][c+i] != 0) {
					q.add(new Point(r, c+i, map[r][c+i]));
					map[r][c+i] = 0;
				}
			}
		}
	}
	
	static class Point{
		int r,c, power;
		Point(int r, int c, int power){
			this.r = r;
			this.c = c;
			this.power = power;
		}
	}
}
