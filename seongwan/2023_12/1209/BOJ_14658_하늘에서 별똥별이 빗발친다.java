import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int L, K, block, temp;
	static int[][] star;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		st.nextToken();
		st.nextToken();
		L = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		star = new int[K][2];

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			star[i][0] = Integer.parseInt(st.nextToken());
			star[i][1] = Integer.parseInt(st.nextToken());
		} // K개의 별의 좌표들을 2차원 배열에 담음 [0]=x,[1]=y

		for (int i = 0; i < K; i++) {
			int x = star[i][0];
			for (int j = 0; j < K; j++) {
				int y = star[j][1];
				int temp = 0;

				for (int k = 0; k < K; k++) {
					int cpx = star[k][0];
					int cpy = star[k][1];

					if (cpx >= x && cpx <= x + L && cpy >= y && cpy <= y + L)
						temp++;
				}
				block = Math.max(block, temp);
			}
		}
		System.out.println(K - block);
	}
}