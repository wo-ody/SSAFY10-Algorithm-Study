import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, m;
	static int[] lectures;
	static int low, high;
	static int answer = 0;
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		lectures = new int[n];
		low = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			lectures[i] = Integer.parseInt(st.nextToken());
			low = low < lectures[i] ? lectures[i] : low;
		}
		high = Arrays.stream(lectures).sum();
		
		solve();
		System.out.println(answer);
	}
	
	public static void solve() {
		while(low <= high) {
			int mid = (low+high) / 2;
			int cnt = 1;
			int temp = 0;
			
			for(int i = 0; i < n; i++) {
				if(temp+lectures[i] > mid) {
					cnt++;
					temp = 0;
				}
				temp += lectures[i];
			}
			
			if (cnt <= m) {
				answer = mid;
				high = mid-1;
			}
			else 
				low = mid+1;
		}
	}
}
