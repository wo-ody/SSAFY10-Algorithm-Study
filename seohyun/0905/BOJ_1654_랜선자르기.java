import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int K,N;
	static int[] line;
	
	static int max_high = -1;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		line = new int[K];
		
		for (int i = 0; i < K; i++) {
			line[i] = Integer.parseInt(br.readLine());
			max_high = Math.max(max_high, line[i]);
		}
		
		System.out.println(BSearch());
	}
	
	static int check_line(long value) {
		if(value == 0) return 0;
		
		int num = 0;
		for (int l : line) {
			num += (l / value);
		}
		
		return num;
	}
	
	static long BSearch() {
		
		long low = 1;
		long high = max_high;
		
		while(low <= high) {
			long mid = (low + high) / 2;
			int value = check_line(mid);
			
			if(value < N) high = mid - 1;
			else low = mid + 1;
		}
		
		return high;
	}

}
