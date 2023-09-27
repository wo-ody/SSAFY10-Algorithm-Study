import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n;
	static int[] arr;
	static int target;
	static int answer;
	
	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		target = Integer.parseInt(br.readLine());
		Arrays.sort(arr);
		bs();
		System.out.println(answer);

	}
	
	static void bs() {
		int low = 0;
		int high = n - 1;
		
		while(low < high) {
			if(arr[low] + arr[high] == target) {
				answer++;
				low++;
				high--;
			}
			else if(arr[low] + arr[high] < target)
				low++;
			else
				high--;
		}
	}

}
