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
	static int[] answer = new int[2];
	static int low, high;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		low = 0;
		high = n - 1;
		tp();
		System.out.println(answer[0] + " " + answer[1]);
	}
	
	static void tp() {
		int sum = 0;
		
		while(low < high) {
			sum = arr[low] + arr[high];
			if(Math.abs(sum) < min) {  // 절대값이 갱신될 때마다
				min = Math.abs(sum);  // 절대값을 기준으로 하면 값이 좌우로 퍼져갈수록 0과 먼 수가 됨
				answer[0] = arr[low];
				answer[1] = arr[high];
				if(sum == 0)  // 정답을 찾았음에도 쓸 데 없는 반복되는 것을 방지하기 위해 
					break;
			}
			// 0에 가깝게 만들어야 하므로
			if(sum > 0)  // 값이 오름차순으로 정렬되어 있기 때문에 합이 0보다 크면 큰 값을 우선 줄여줌
				high--;
			else if(sum < 0)  // 마찬가지로 합이 0보다 작으면 가장 작은 값을 우선 줄여줌
				low++;
		}
	}
}
