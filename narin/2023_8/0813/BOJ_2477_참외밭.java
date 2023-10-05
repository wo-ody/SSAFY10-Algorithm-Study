import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int K;
	private static int[] d, len;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		K = Integer.parseInt(br.readLine());
		d = new int[6];
		len = new int[6];

		int maxM = 0, maxN = 0;
		int idxM = 0, idxN = 0;

		for (int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine());
			d[i] = Integer.parseInt(st.nextToken());
			len[i] = Integer.parseInt(st.nextToken());
			if (d[i] == 1 || d[i] == 2) {
				if (len[i] > maxM) {
					maxM = len[i];
					idxM = i;
				}
			} else {
				if (len[i] > maxN) {
					maxN = len[i];
					idxN = i;
				}
			}

		}

		int smallM = len[(idxM + 3) % 6];
		int smallN = len[(idxN + 3) % 6];

		int area = (maxM * maxN) - (smallM * smallN);

		System.out.println(area * K);
	}
}
