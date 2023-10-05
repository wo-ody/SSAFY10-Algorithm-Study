import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int T, cntzero[], cntone[];

	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(br.readLine());
		cntzero = new int[41];
		cntone = new int[41];
		cntzero[0] = 1;
		cntone[1] = 1;
		for (int i = 2; i <= 40; i++) {
			cntzero[i] = cntzero[i - 2] + cntzero[i - 1];
			cntone[i] = cntone[i - 2] + cntone[i - 1];
		}
		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			sb.append(cntzero[n] + " " + cntone[n] + "\n");
		}
		System.out.println(sb);
	}

}