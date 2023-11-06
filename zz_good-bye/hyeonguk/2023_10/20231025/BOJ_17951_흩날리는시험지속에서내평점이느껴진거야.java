import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, K, answer;
	static int[] papers;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		papers = new int[N];
		int start = 0;
		int end = 0;
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			papers[i] = Integer.parseInt(st.nextToken());
			end += papers[i];
		}
		
		while(start <= end) {
			int mid = (start+end)/2;
			if(check(mid)) {
				answer = mid;
				start = mid + 1;
			}else {
				end = mid - 1;
			}
		}
		
		System.out.println(answer);
	}
	static boolean check(int num) {
		int sum = 0;
		int cnt = 0;
		for(int i=0; i<N; i++) {
			sum += papers[i];
			if(sum >= num) {
				cnt++;
				sum = 0;
			}
		}
		if(cnt>= K) return true;
		return false;
	}
}
