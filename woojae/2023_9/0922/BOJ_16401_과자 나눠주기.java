import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int m, n;
	static int[] cookies;
	static int answer = 0;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		cookies = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++)
			cookies[i] = Integer.parseInt(st.nextToken());
		bs();
		System.out.println(answer);
	}
	
	static int bs() {
		int low = 1;
		int high = Arrays.stream(cookies).max().getAsInt();
		int mid = 0;
		
		
		while(low <= high) {
			int target = 0;
			mid = (low + high) / 2;
			
			for (int i : cookies)
				target += (i / mid);
			if(target < m)
				high = mid - 1;
			else {
				low = mid + 1;
				answer = mid;
			}
		}
		return mid;
	}

}