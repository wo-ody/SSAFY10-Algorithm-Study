import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class BOJ_8911_거북이 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N;

	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			int d = 0;
			int d1 = 0;
			int x = 0;
			int y = 0;
			int maxX = 0;
			int minX = 0;
			int maxY = 0;
			int minY = 0;
			String[] s = br.readLine().split("");
			for (int j = 0; j < s.length; j++) {
				switch (s[j]) {
				case "L":
					d--;
					if (d == -1) {
						d = 3;
					}
					break;
				case "R":
					d++;
					if (d == 4) {
						d = 0;
					}
					break;
				case "B":
					d1 = (d + 2) % 4;
					x += dx[d1];
					y += dy[d1];
					maxX = Math.max(x, maxX);
					maxY = Math.max(y, maxY);
					minX = Math.min(x, minX);
					minY = Math.min(y, minY);
					break;
				case "F":
					d1 = d;
				default:
					x += dx[d1];
					y += dy[d1];
					maxX = Math.max(x, maxX);
					maxY = Math.max(y, maxY);
					minX = Math.min(x, minX);
					minY = Math.min(y, minY);
					break;
				}
			/*	bw.write("x: " + x + " y: " + y + " maxX: " + maxX + " minX: " + minX + " maxY: " + maxY + " minY: "
						+ minY +"s: "+s[j]+" d: "+d+ "\n");*/

			}
			int S = (maxX - minX) * (maxY - minY);
			bw.write(Integer.toString(S)+"\n");
		}

		bw.flush();
		bw.close();
	}
}