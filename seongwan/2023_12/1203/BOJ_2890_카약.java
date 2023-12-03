import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int R, C;
	static TreeSet<Integer> rank = new TreeSet<>();
	static int[] dis = new int[10];// 결승선으로부터의 거리 계산

	public static void main(String[] args) throws Exception {

		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		for (int i = 0; i < R; i++) {
			char[] line = br.readLine().toCharArray();
			for (int j = 1; j < C - 1; j++) {// 시작, 결승선 제외
				if (line[j] != '.') {
					dis[line[j] - '0'] = C - 1 - j;// .이 아닌 카약이 나오면 그 번호의 결승선으로부터의 거리 체크
					break;
				}
			}
		}

		for (int i = 1; i <= 9; i++) {
			rank.add(dis[i]);
		}
		Object[] rankarr = rank.toArray();
		for (int i = 1; i <= 9; i++) {
			for (int j = 0; j < rankarr.length; j++) {
				if (dis[i] == (int) rankarr[j]) {
					System.out.println(j + 1);
				}
			}
		}
	}
}