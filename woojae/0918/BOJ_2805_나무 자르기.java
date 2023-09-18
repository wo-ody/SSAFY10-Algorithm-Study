import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, m;  // m == answer
	static int[] woods;
	static int low, high, mid;
	static long target;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		woods = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++)
			woods[i] = Integer.parseInt(st.nextToken());
		low = 1;
		high = Arrays.stream(woods).max().getAsInt();
		
		while(low <= high) {
			mid = (low + high) / 2;
			target = 0;
			
			for(int i = 0; i < n; i++)
				target += (woods[i] > mid ? woods[i] - mid : 0);
			
			if(target < m)
				high = mid - 1;
			else
				low = mid + 1;
		}
		System.out.println(high);

	}

}