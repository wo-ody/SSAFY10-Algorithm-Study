import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int score[][] = new int[9][2];
	static int ans;
	static boolean[] select = new boolean[9];

	public static void main(String[] args) throws Exception {
		for (int i = 1; i <= 8; i++) {
			score[i] = new int[] { i, Integer.parseInt(br.readLine()) };
		}

		Arrays.sort(score, (e1, e2) -> e2[1] - e1[1]);

		for (int i = 0; i < 5; i++) {
			select[score[i][0]] = true;
			ans += score[i][1];
		}
		System.out.println(ans);
		for (int i = 1; i <= 8; i++) {
			if (select[i])
				System.out.print(i + " ");
		}
	}
}