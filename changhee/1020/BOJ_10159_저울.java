import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder answer = new StringBuilder();
		
		int n =Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		int[][] arr =new int[n+1][n+1];
		
		for(int i =0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y =Integer.parseInt(st.nextToken());
			
			arr[x][y] = 1;
			arr[y][x] = -1;
		}
		
		for(int k=1; k<n+1; k++) {
			for(int i =1; i<n+1; i++) {
				for(int j =1; j<n+1; j++) {
					if(arr[i][k] == 1 && arr[k][j] == 1) arr[i][j] =1;
					if(arr[i][k] == -1 && arr[k][j] == -1) arr[i][j] =-1;
				}
			}
		}
		
		for(int i =1; i<n+1; i++) {
			int result = 0;
			for(int j =1; j<n+1; j++) {
				if(i!=j && arr[i][j]==0) result++;
			}
			
			answer.append(result).append("\n");
		}
		
		System.out.println(answer);
	}
}
