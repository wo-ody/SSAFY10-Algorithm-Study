import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2630_색종이만들기 {
	static int N;
	static int[][] map;
	static int white,blue;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		find(0,0,N);
		System.out.println(white);
		System.out.println(blue);
	}
	
	static int isPossible(int x, int y, int size) {
		int color = map[x][y];
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if(map[i][j] != color) return -1;
			}
		}
		
		if(color == 0) white++;
		else blue++;
		
		return color;
	}
	
	static void find(int x, int y, int size) {
		int num = isPossible(x, y, size);
		if(num == 0 || num == 1) return;
		
		int new_size = size / 2;
		
		find(x, y, new_size);
		find(x, y + new_size, new_size);
		find(x + new_size, y, new_size);
		find(x + new_size, y + new_size, new_size);
	}
	
	

}
