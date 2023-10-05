import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int rc, num;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int col = Integer.parseInt(st.nextToken());
		int row = Integer.parseInt(st.nextToken());

		int[] cutR = new int[row + 1];
		int[] cutC = new int[col + 1];

		int N = Integer.parseInt(br.readLine());
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			rc = Integer.parseInt(st.nextToken());
			num = Integer.parseInt(st.nextToken());

			if (rc == 0) {
				cutR[num] = 1;
			} else {
				cutC[num] = 1;
			}
		}

		int temp = 0;
		int maxR = 0, maxC = 0;

		for (int i = 1; i <= row; i++) {
			temp++;
			if (cutR[i] == 1 || i == row) {
				maxR = Math.max(maxR, temp);
				temp = 0;
			}
		}

		temp = 0;
		for (int i = 1; i <= col; i++) {
			temp++;
			if (cutC[i] == 1 || i == col) {
				maxC = Math.max(maxC, temp);
				temp = 0;
			}
		}

		System.out.println(maxC * maxR);
	}
}
