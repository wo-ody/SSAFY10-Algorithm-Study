import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	static int N, M;
	static long[] A, B;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		A = new long[M];
		B = new long[N];

		for (int i = 0; i < M; i++) {
			A[i] = Long.parseLong(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			B[i] = Long.parseLong(br.readLine());
		}
		
		for(int i=1; i<M; i++) {
			A[i] = A[i]+A[i-1];

		}
		
		for(int i=0; i<N; i++) {
			
			int target = Arrays.binarySearch(A, B[i]);
			if(target < 0 )
				target = Math.abs(target+1);
			
			if(target+1 > M) {
				sb.append("Go away!\n");
			}else {
				sb.append(target+1).append("\n");
			}
			
		}
		System.out.println(sb);
	}
}
