import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int A, B, N;

	public static void main(String[] args) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());

		N = Integer.parseInt(br.readLine());
		int[] button = new int[N];
		for (int i = 0; i < N; i++) {
			button[i] = Integer.parseInt(br.readLine());
		}

		int min = Math.min(Math.abs(A - B), Math.abs(button[0] - B) + 1);

		for (int i = 1; i < N; i++) {
			min = Math.min(min, Math.abs(button[i] - B) + 1);
		}

		System.out.println(min);
	}
}