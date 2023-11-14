import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {// 가로마다 체크해서 블록과 블록 사이의 빈 값의 개수를 구함
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int H, W, ans, blank;
	static int[] block;
	static boolean chk;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());

		block = new int[W];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < W; i++) {
			block[i] = Integer.parseInt(st.nextToken());
		} // 입력

		for (int i = 0; i < H; i++) {
			chk = false;
			blank = 0;
			for (int j = 0; j < W; j++) {
				if (block[j] > 0) {// 블록을 만난 상황
					if (chk) {// 가로 체크 중 이미 한 번 블록을 만난 뒤 다시 블록을 만난 상황이면
						ans += blank;
						blank = 0;
					} else// 처음 블록을 만난 상황이면
						chk = true;
				} else {// 빈 칸을 만난 상황
					if (chk) // 빈 칸을 만났던 상황이면
						blank++;
				}
				block[j]--;// 다음 칸 체크를 위해 1씩 감소
			}
		}
		System.out.println(ans);

	}

}