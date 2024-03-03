import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int n;
	static long[] arr;
	static long[] answer = new long[3];
	
	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		arr = new long[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++)
			arr[i] = Long.parseLong(st.nextToken());
		Arrays.sort(arr);

		long target = Long.MAX_VALUE;
		long temp;
		
		for(int i = 0; i < n; i++) {
			int low = i+1, high = n-1;  // 기준 용액이 바뀔 때마다 포인터 초기화
			
			while(low < high) {
				temp = arr[i] + arr[low] + arr[high];
				
				if(Math.abs(temp) < target) {
					answer[0] = arr[i];
					answer[1] = arr[low];
					answer[2] = arr[high];
					target = Math.abs(temp);
				}
				
				if(temp == 0)
					break;
				else if(temp < 0)
					low++;
				else
					high--;
			}
		}
		sb.append(answer[0]).append(" ").append(answer[1]).append(" ").append(answer[2]);
		System.out.println(sb);
	}
}
