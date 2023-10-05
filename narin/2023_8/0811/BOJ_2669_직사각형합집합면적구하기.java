import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x1, y1, x2, y2;
		int[][] area = new int[100][100];
		int count = 0;

		for (int n = 0; n < 4; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());

			for (int i = x1; i < x2; i++) {
				for (int j = y1; j < y2; j++) {
					area[i][j] = 1;
				}
			}
		}

		for (int i = 0; i < area.length; i++) {
			for (int j = 0; j < area.length; j++) {
				if (area[i][j] == 1)
					count++;
			}
		}

		System.out.println(count);

	}
}
