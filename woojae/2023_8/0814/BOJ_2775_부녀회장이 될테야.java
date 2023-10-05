import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < t; tc++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			sb.append(solve(k, n)).append("\n");
		}
		System.out.println(sb);
	}
	
	static int solve(int k, int n) {
		int[][] apartment = new int[k + 1][n + 1];  // 0층도 층이기 때문에 k + 1, 호실은 계산의 편의를 위해 더미값 삽입
		for(int i = 1; i < n + 1; i++)  // 0층 거주민 초기화
			apartment[0][i] = i;
		
		for(int i = 1; i < k + 1; i++)
			for(int j = 1; j < n + 1; j++)
				apartment[i][j] = apartment[i - 1][j] + apartment[i][j - 1];  // 현재층 현재 호실의 거주중인 사람의 총수 = 이전 호실 + 아래층 동일 호실
		return apartment[k][n];
	}
}
