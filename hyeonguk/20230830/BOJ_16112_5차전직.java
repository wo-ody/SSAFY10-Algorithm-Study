import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static long answer;
	static int N, K;
	static long[] stones;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		stones = new long[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			stones[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(stones);

		answer = 0;
		for(int i=0; i<K; i++) {
			answer += stones[i] * i;
		}
		
		for(int i=K; i<N; i++) {
			answer += stones[i] * K;
		}
		
		System.out.println(answer);	
	}
}
