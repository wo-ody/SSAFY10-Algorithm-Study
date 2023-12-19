import java.io.*;
import java.io.*;

public class Solution {
	static int[][] map;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		conquer(0,0,N); 
		System.out.println(sb);
	}
	static void conquer(int iStart, int jStart, int size) {
		int sum = 0;
		for (int i = iStart; i < iStart+size; i++) {
			for (int j = jStart; j < jStart+size; j++) {
				sum += map[i][j];
			}
		}
		if(sum == size*size) {
			sb.append(1);
			return; 
		} else if(sum == 0) {
			sb.append(0);
			return;
		} else { 
			sb.append('(');
			
			conquer(iStart, jStart, size/2); //좌상
			conquer(iStart, jStart+(size/2), size/2); //우상
			conquer(iStart+(size/2), jStart, size/2); //좌하
			conquer(iStart+(size/2), jStart+(size/2), size/2); //우하
			
			sb.append(')'); 
		}
	}
}
