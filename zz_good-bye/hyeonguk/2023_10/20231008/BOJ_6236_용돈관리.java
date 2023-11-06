import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, K;
	static int[] money;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int max = 0;
		money = new int[N];
		for(int i=0; i<N; i++) {
			money[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, money[i]);
		}

		K = 10000 * 100000; 
		int start = max;
		int end = K;
		while(start <= end) {
			int mid = (start+end)/2;
			
			if(countMoney(mid) <= M) {
				K = mid;
				end = mid - 1;
			}else {
				start = mid + 1;
			}
			
		}
		
		System.out.println(K);
		
	}
	
	static int countMoney(int K) {
		int cnt = 1;
		int copyK = K;
		boolean check = false;
		
		for(int i=0; i<N; i++) {
			copyK -= money[i];
			if(copyK < 0) {
				cnt++;
				copyK = K - money[i];
			}
		}
		return cnt;
	}

}
