import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//for문을 통해 점수 비교 후 중간에 들어갈 자리가 있다면 그 자리로 랭킹 갱신 없다면 제일 뒤의 자리로 랭킹 등록
//랭킹의 맨 뒤 점수보다 작거나 같다면 랭킹 갱신 불가능으로 -1 출력
public class Main{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, score, P;
	static int[] input;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		score = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());

		if (N == 0) {// 무조건 새 점수인 경우
			System.out.println(1);
			return;
		}

		// 점수들 정보 입력
		input = new int[P + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		// 랭킹에 들어갈 수 없는 경우
		if (N == P && input[P] >= score)
			System.out.println(-1);

		else {
			for (int i = 1; i <= N; i++) {
				if (input[i] <= score) {
					System.out.println(i);
					return;
				}
			}
			// 원래 있던 점수들보다 낮지만 랭킹 등록이 가능한 경우
			System.out.println(N + 1);
		}
	}
}
