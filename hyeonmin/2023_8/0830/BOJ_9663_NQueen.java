import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9663_NQueen {

	static int N, ans;
	static int[] chess;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		ans = 0;
		chess = new int[N];
		
		nQueen(0);
		System.out.println(ans);
	}
	
	static void nQueen(int depth) {
		if(depth == N) {
			ans++;
			return;
		}
		
		for (int i = 0; i < N; i++) {
			chess[depth] = i;
			
			if(checkQueen(depth)) {
				nQueen(depth + 1);
			}
		}
		
	}
	
	static boolean checkQueen(int col) {
		
		for (int j = 0; j < col; j++) {
			if(chess[col] == chess[j]
			|| Math.abs(col - j) == Math.abs(chess[col] - chess[j])) {
				return false;
			}
		}
		return true;
	}

}
