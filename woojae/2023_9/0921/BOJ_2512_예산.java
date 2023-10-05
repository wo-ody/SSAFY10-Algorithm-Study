import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n;
	static int[] request;
	static int m;
	
	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		request = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++)
			request[i] = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(br.readLine());
		bs();

	}
	
	static void bs() {
		int low = 1;
		int high = Arrays.stream(request).max().getAsInt();
		int upper_bound = 0;
		long result;
		
		while(low <= high) {
			upper_bound = (low + high) / 2;
			result = 0;
			for (int i : request)
				result += (i <= upper_bound ? i : upper_bound);
			if(result <= m)  // 만들어진 예산이 주어진 예산보다 작다면 파이를 늘려줘야 함
				low = upper_bound + 1;  // high의 범위를 줄일 땐 result < m의 조건을 걸어줘야 함
			else
				high = upper_bound - 1;
		}
		System.out.println(high);
	}
}
