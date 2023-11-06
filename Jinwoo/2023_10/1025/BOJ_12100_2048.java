import java.io.*;
import java.util.*;
public class BOJ_12100_2048 {
	static int[][] map;
	static int ans=0, n;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<n; j++) map[i][j] = Integer.parseInt(st.nextToken());
		}

		bt(0);
		System.out.println(ans);
	}
	
	static void bt(int d) {
		if (d==5) {
			for (int i=0; i<n; i++) {
				for (int j=0; j<n; j++) ans = Math.max(ans, map[i][j]);
			}
			return;
		}
		int[][] mapc = new int[n][n];
		for (int i=0;i<n; i++) mapc[i] = map[i].clone();
		
		//up
		for (int l=0; l<n; l++) {
			int a=0, b=1;
			while (b<n) {
				if (map[b][l]==0) {b++; continue;}
				if (map[a][l]==0) {
					map[a][l] = map[b][l]; map[b][l]=0;
				}else if (map[a][l]==map[b][l]) {
					map[a][l]<<=1; map[b][l]=0;
					a++; b++;
				}else {
					if (++a==b) b++;
					else {
						map[a][l] = map[b][l]; map[b][l]=0;
						b++;
					}
				}
			}
		}
		bt(d+1);
		//down
		for (int i=0;i<n; i++) map[i] = mapc[i].clone();
		for (int l=0; l<n; l++) {
			int a=n-1, b=n-2;
			while (b>=0) {
				if (map[b][l]==0) {b--; continue;}
				if (map[a][l]==0) {
					map[a][l] = map[b][l]; map[b][l]=0;
				}else if (map[a][l]==map[b][l]) {
					map[a][l]<<=1; map[b][l]=0;
					a--; b--;
				}else {
					if (--a==b) b--;
					else {
						map[a][l] = map[b][l]; map[b][l]=0;
						b--;
					}
				}
			}
		}
		bt(d+1);
		//left
		for (int i=0;i<n; i++) map[i] = mapc[i].clone();
		for (int l=0; l<n; l++) {
			int a=0, b=1;
			while (b<n) {
				if (map[l][b]==0) {b++; continue;}
				if (map[l][a]==0) {
					map[l][a] = map[l][b]; map[l][b]=0;
				}else if (map[l][a]==map[l][b]) {
					map[l][a]<<=1; map[l][b]=0;
					a++; b++;
				}else {
					if (++a==b) b++;
					else {
						map[l][a] = map[l][b]; map[l][b]=0;
						b++;
					}
				}
			}
		}
		bt(d+1);
		
		//right
		for (int i=0;i<n; i++) map[i] = mapc[i].clone();
		for (int l=0; l<n; l++) {
			int a=n-1, b=n-2;
			while (b>=0) {
				if (map[l][b]==0) {b--; continue;}
				if (map[l][a]==0) {
					map[l][a] = map[l][b]; map[l][b]=0;
				}else if (map[l][a]==map[l][b]) {
					map[l][a]<<=1; map[l][b]=0;
					a--; b--;
				}else {
					if (--a==b) b--;
					else {
						map[l][a] = map[l][b]; map[l][b]=0;
						b--;
					}
				}
			}
		}
		bt(d+1);
		
	}
	
}
