import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		boolean[][] arr = new boolean[n + 1][n + 1];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			arr[x][y] = true;
		}

		for (int k = 1; k < n + 1; k++) {
			for (int i = 1; i < n + 1; i++) {
				for (int j = 1; j < n + 1; j++) {
					if (!arr[i][k] || !arr[k][j]) continue;
					arr[i][j] = true;
				}
			}
		}
		
		int answer = 0;
		for(int i =1; i<n+1; i++) {
			int count = 0;
			for(int j = 1; j<n+1; j++) {
				if(arr[i][j] || arr[j][i]) count++;
			}
			
			if(count == n-1) answer++;
		}
		
		System.out.println(answer);
	}
}
