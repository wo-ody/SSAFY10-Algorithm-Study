import java.io.*;
import java.util.*;

public class Main {
	
	static int[] dx = {1, -1, 0 ,0};
	static int[] dy = {0, 0, 1, -1};
	static int[][] house;
	static int m, n;
	static Queue<int[]> queue = new LinkedList<int[]>(); 
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		house = new int[n][m];
		
		for(int i = 0; i < n; i++){
			StringTokenizer tomato = new StringTokenizer(br.readLine()," ");
			for(int j = 0; j < m; j++){
				house[i][j] = Integer.parseInt(tomato.nextToken());
				if(house[i][j] == 1) queue.offer(new int[] {i,j});
			}
		}
		
		bfs();
		
		int result = 0;
		int maxDay = 0;
		
		for(int[] var : house){
			for(int variable : var){
				if (variable == 0){
					System.out.println(-1);
					System.exit(0);
				}
				result = Math.max(result, variable);
			}
		}
		
		System.out.println(result);
	}
	
	static void bfs(){
		while(!queue.isEmpty()){
			int[] xAndY = queue.poll();
			int x = xAndY[0];
			int y = xAndY[1];
			
			for(int i = 0; i <4; i++){
				int nx = x + dx[i];
				int ny = y + dy[i];
				if ((0 <= nx && nx < n) && (0 <= ny && ny < m) && house[nx][ny] == 0){
					house[nx][ny] = house[x][y] + 1;
					queue.offer(new int[] {nx,ny});
				}
			}
		}
	}
}
