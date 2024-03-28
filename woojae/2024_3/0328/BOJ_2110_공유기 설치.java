import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, c;
	static int[] arr;
	static int answer = 0;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(br.readLine());
		Arrays.sort(arr);
		
		int low = 1;
		int high = arr[n-1] - arr[0]+1;
		
		while(low + 1 < high) {
			int mid = (low + high) / 2;
			if(check(mid))
				low = mid;
			else
				high = mid;
		}
		
		System.out.println(low);
	}
	
	static boolean check(int distance) {
		int cnt = 1;
		int current = arr[0];
		
		for(int i = 1; i < n; i++) {
			if(arr[i] >= current + distance) {
				cnt++;
				current = arr[i];
			}
		}
		
		return cnt >= c;
	}

}
