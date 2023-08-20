import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13458_시험감독 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[] testTaker = new int[N];
		
		long count = N;
		// 총감독관은 B명까지 가능, 부감독관은 C명까지 가능, 몇명의 감독관이필요한가?
		// 각 시험장에 총감독관은 1명만 있어야 함.
		// 일단 총 감독관으로 먼저 다 채우고, 부족하면 부 감독관도 추가 한다.
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			testTaker[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			if(testTaker[i] < B) continue;
			else {
				testTaker[i] -= B;
				if(testTaker[i] > 0) {
					count += Math.ceil( (float) testTaker[i] / (float) C );
				}
			}
		}
		
		System.out.println(count);
		
	}

}
