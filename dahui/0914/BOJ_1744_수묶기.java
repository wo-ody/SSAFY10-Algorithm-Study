import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static int N, answer;
	public static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		
		// 최대 최소 기준
		// 1. 음수 * 음수 (단, 큰 수 끼리 곱해야 큰 수가 됨을 주의)
		// 2. 양수 * 양수  (단, 큰 수 끼리 곱해야 큰 수가 됨을 주의)
		// 3. 만약 1이 포함된다면 *1 이아닌 +1을 한 수가 더 큰 수
		// 4. 만약 음수하나와 0만 남아있다면 음수 * 0 즉, 0이 큰 수
		
		for (int i = 0; i < N; ++i) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		int minusIdx = 0;
		// 음수 ~ 0까지의 수를 처리
		while (minusIdx < N && arr[minusIdx] < 1) {
			// 곱한 값이 양수가 된다면
			if (minusIdx + 1 < N && arr[minusIdx + 1] < 1) {
				answer += (arr[minusIdx] * arr[minusIdx + 1]);
				minusIdx += 2;
			}
			else {
				// 양수가 아니라면 그냥 더한다.
				// 즉, 0이거나 음수가 하나만 남았을 경우
				answer += arr[minusIdx++];
			}
		}
		
		int plusIdx = N - 1;
		// 양수를 처리
		while (plusIdx >= minusIdx && arr[plusIdx] > 0) {
			// 1은 곱하지 않게하고 다른 두 양수를 곱하게한다.
			if (plusIdx - 1 >= minusIdx && arr[plusIdx - 1] > 1) {
				answer += (arr[plusIdx] * arr[plusIdx - 1]);
				plusIdx -= 2;
			}
			else {
				// 1이거나 양수가 하나만 남았다면 그냥 더해준다.
				answer += arr[plusIdx--];
			}
		}
		
		System.out.println(answer);
	}
}
