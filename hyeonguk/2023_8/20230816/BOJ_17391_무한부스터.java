import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	// 동, 남
	static int[] dx = {1, 0};
	static int[] dy = {0, 1};
	static int N, M;
	static int[][] array;
	static int[][] answers;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		array = new int[N][M];
		answers = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		bfs(0,0);
		System.out.println(answers[N-1][M-1]);
	}
	
	static void bfs(int i, int j) {
		Queue<Integer[]> queue = new ArrayDeque<>();
		answers[i][j] = 0;
		
		queue.offer(new Integer[] {i, j});
		while(!queue.isEmpty()) {
			Integer[] item = queue.poll();
			int y = item[0];
			int x = item[1];
			int maxDistance = array[y][x];
			
			for(int d=0; d<2; d++) {
                for(int m=1; m<=maxDistance; m++){
					int ny = y + dy[d]*m;
					int nx = x + dx[d]*m;
					
					if(ny>=N || nx >=M) continue;
					if(answers[ny][nx]!=0) continue;
					answers[ny][nx] = answers[y][x]+1;
					queue.offer(new Integer[] {ny, nx});
                }
			}
		}
	}
}
