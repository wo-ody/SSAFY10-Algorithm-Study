import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//수를 입력 받은 뒤에 맨 뒤의 값을 저장하고, 뒤에서부터 입력값을 탐색한다.
//탐색 중 저장한 값보다 더 낮은 수가 나온다면 저장해놓은 수와의 차이만큼 답에 더하고 더 높은 수가 나온다면 저장해놓은 값을 갱신한다.
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] input;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			input = new int[N];
			long ans = 0;

			//입력값 받기
			for (int j = 0; j < N; j++) {
				input[j] = Integer.parseInt(st.nextToken());
			}

			int high = input[N - 1];

			for (int j = N - 2; j >= 0; j--) {
				int temp = input[j];

				//주식으로 돈을 얻을 수 있는 경우
				if (high > temp) {
					ans += high - temp;
				}//판매할 주식의 가격을 갱신해야 하는 경우
				else {
					high = temp;
				}
			}
			sb.append(ans + "\n");
		}
		System.out.println(sb);
	}
}