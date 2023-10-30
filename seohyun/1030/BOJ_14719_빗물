package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_14719_빗물 {
	static int H,W;
	static int[][] map;
	
	static int result = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		
		int[] input = new int[W];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < W; i++) {
			int num = Integer.parseInt(st.nextToken());
			int j = H-1;
			for (int j2 = 0; j2 < num; j2++) {
				map[j--][i] = 1;
			}
		}
		
		simulation();
		System.out.println(result);
		
	}
	
	static void simulation() {
		for (int i = 0; i < H; i++) {
			int j = 0;
			while(true) {
				if(map[i][j] == 1) {
					int j2;
					for (j2 = j + 1; j2 < W; j2++) {
						if(map[i][j2] == 1) {
							result += (j2 - j - 1);
							break;
						}
					}
					j = j2 - 1;
				}
				j++;
				
				if(j >= W) break;
			}
		}
	}

}
