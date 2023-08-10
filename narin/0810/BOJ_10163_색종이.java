import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static int N;
	private static int[][] area = new int[1001][1001];
	private static int width, height;
	private static int x, y;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			width = Integer.parseInt(st.nextToken());
			height = Integer.parseInt(st.nextToken());

			for (int i = x; i < x + width; i++) {
				for (int j = y; j < y + height; j++) {
					area[i][j] = n + 1;
				}
			}
		}

		for (int n = 0; n < N; n++) {
			int count = 0;
			for (int i = 0; i < area.length; i++) {
				for (int j = 0; j < area.length; j++) {
					if (area[i][j] == n + 1) {
						count++;
					}
				}
			}
			System.out.println(count);
		}
	}

}
