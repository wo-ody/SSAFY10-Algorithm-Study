package algorithm2023.mar;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class BOJ_5212_지구온난화 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int R;
	static int C;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		String[] s = br.readLine().split(" ");
		R = Integer.parseInt(s[0]);
		C = Integer.parseInt(s[1]);
		char[][] map = new char[R][C];
		for (int i = 0; i < R; i++) {
			char[] arr = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				map[i][j] = arr[j];
			}
		}
		int maxX = 0;
		int minX = 10;
		int maxY = 0;
		int minY = 10;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'X') {
					int cntSea = 0;
					for (int k = 0; k < 4; k++) {
						int nextX = i + dx[k];
						int nextY = j + dy[k];
						if (nextX < 0 || nextX >= R || nextY < 0 || nextY >= C) {
							cntSea++;
							continue;
						}
						if(map[nextX][nextY]=='.') {
							cntSea++;
						}
					}
					if(cntSea>=3) {
						map[i][j] = ' ';
					}else {
						if(i>=maxX) {
							maxX = i;
						}
						if(i<=minX) {
							minX = i;
						}
						if(j>=maxY) {
							maxY = j;
						}
						if(j<=minY) {
							minY = j;
						}
					}
				}
			}
		}
		for(int i = minX;i<=maxX;i++) {
			for(int j = minY;j<=maxY;j++) {
				if(map[i][j]==' ') {
					map[i][j] = '.';
				}
				bw.write(map[i][j]);
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();

	}
}