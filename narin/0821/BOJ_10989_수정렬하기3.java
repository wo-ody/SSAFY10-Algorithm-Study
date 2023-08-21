import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[10001];

		for (int i = 0; i < N; i++) {
			num[Integer.parseInt(br.readLine())]++;
		}

		for (int i = 1; i <= 10000; i++) {
			for (int j = 0; j < num[i]; j++) {
				sb.append(i + "\n");
			}
		}
		System.out.println(sb);
	}
}
