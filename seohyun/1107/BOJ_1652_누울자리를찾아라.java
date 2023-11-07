import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static char[][] map;
	
	static int row, col;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new char[N+1][N+1];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0;j<N;j++) {
				map[i][j] = str.charAt(j);
			}
			map[i][N] = 'X';
			map[N][i] = 'X';
		}
		
		simulation();
		System.out.println(row + " " + col);
	}
	
	static void simulation() {
		// 가로 누울 곳
		
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			cnt = 0;
			for (int j = 0; j <= N; j++) {
				if(map[i][j] == '.') {
					cnt++;
				}
				else {
					if(cnt >= 2) row++;
					cnt = 0;
				}
			}
		}
		
		// 세로 누울 곳
		for (int i = 0; i < N; i++) {
			cnt = 0;
			for (int j = 0; j <= N; j++) {
				if(map[j][i] == '.') {
					cnt++;
				}
				else {
					if(cnt >= 2) col++;
					cnt = 0;
				}
			}
		}
		
		
	}

}
