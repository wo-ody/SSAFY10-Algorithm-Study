import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, cnt, length;
	static int[][] array;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 값 입력받기
		N = Integer.parseInt(br.readLine());
		array = new int[N][N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		cnt = 0;
		length = N-1;
		bfs(0, 1, 0);
		System.out.println(cnt);
	}

	static void bfs(int i, int j, int direction) {
		Queue<Integer[]> queue= new ArrayDeque<>();
		
		queue.offer(new Integer[] {i, j, direction});
		
		while(!queue.isEmpty()) {
			Integer[] item = queue.poll();
			
			int y = item[0];
			int x = item[1];
			int now_direction = item[2];
			
			if(y == length && x == length) {
				cnt++;
				continue;
			}
			
			int ny = y + 1;
			int nx = x + 1;
			
			// 가로
			if(now_direction != 1) {
				if(nx < N && array[y][nx] == 0) queue.offer(new Integer[] {y, nx, 0});
			// 세로
			}
			if(now_direction != 0) {
				if(ny < N && array[ny][x] == 0) queue.offer(new Integer[] {ny, x, 1});
			}
			
			// 대각선
			if( nx > length || ny > length) continue;
			if(array[ny][x] == 0 && array[y][nx] == 0 && array[ny][nx] == 0) 
				queue.offer(new Integer[] {ny, nx, 2});
		}
	}
}
