import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while (true) {
			int[] len = new int[3];
			st = new StringTokenizer(br.readLine());
			len[0] = Integer.parseInt(st.nextToken());
			len[1] = Integer.parseInt(st.nextToken());
			len[2] = Integer.parseInt(st.nextToken());

			if (len[0] == 0 && len[1] == 0 && len[2] == 0) {
				break;
			}

			Arrays.sort(len);
			int a = len[0];
			int b = len[1];
			int c = len[2];

			if (a * a + b * b == c * c) {
				System.out.println("right");
			} else {
				System.out.println("wrong");
			}
		}
	}
}
