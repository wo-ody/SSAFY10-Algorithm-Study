import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//집합 A를 boolean 배열에 true로 놓고
//B를 돌면서 boolean 배열 체크 후 true인 애들의 개수*2를 총 개수에서 빼면 끝
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int A, B, cnt;
	static boolean[] chk = new boolean[100000001];

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());

		// 집합 A 체크
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < A; i++) {
			chk[Integer.parseInt(st.nextToken())] = true;
		}

		// 집합 B체크
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < B; i++) {
			if (chk[Integer.parseInt(st.nextToken())])
				cnt++;
		}
		System.out.println(A + B - cnt * 2);
	}
}