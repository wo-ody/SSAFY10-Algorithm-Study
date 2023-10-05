import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11728_배열합치기 {

	static int N, M;
	static int[] A, B, answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		A = new int[N];
		B = new int[M];
		answer = new int[N+M];
		
		// A 배열 입력받기
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		// B 배열 입력받기
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		System.arraycopy(A, 0, answer, 0, N);
		System.arraycopy(B, 0, answer, N, M);
		Arrays.sort(answer);
		
		for (int i = 0; i < N+M; i++) {
			sb.append(answer[i]).append(" ");
		}
		
		System.out.println(sb);
	}

}
