import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_11931_수정렬하기4 {

	static int N;
	static Integer[] A;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		A = new Integer[N];
		
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(A, (a, b) -> b - a );
		
		for (int i = 0; i < N; i++) {
			sb.append(A[i]).append("\n");
		}
		
		System.out.println(sb);
	}

}
