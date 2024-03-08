import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int n;
	static int[] arr;
	static int[] answer = new int[2];
	
	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		int low = 0, high = n-1;
		int temp;
		int target = Integer.MAX_VALUE;
		
		while(low < high) {
			temp = arr[low] + arr[high];
			
			if(Math.abs(temp) < target) {
				answer[0] = arr[low];
				answer[1] = arr[high];
				target = Math.abs(temp);
			}
			
			if(temp == 0)
				break;
			else if(temp < 0)
				low++;
			else
				high--;
		}
		sb.append(answer[0]).append(" ").append(answer[1]);
		System.out.println(sb);
	}
}
