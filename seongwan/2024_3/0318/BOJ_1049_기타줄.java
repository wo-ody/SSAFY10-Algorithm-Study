import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//6개의 가격 최소와 낱개 가격 최소만을 본다.
//끊어진 줄이 6을 넘는다면 6개 가격과 낱개 6개의 가격을 비교
//싼 가격으로 6을 나눈 몫만큼 샀다고 처리한 후
//나머지 줄과 낱개 가격의 곱과 6개의 값을 비교한 후 싼 값으로 사는 처리
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int ans = 0;
		int sixmin = Integer.MAX_VALUE;
		int onemin = Integer.MAX_VALUE;

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int six = Integer.parseInt(st.nextToken());
			int one = Integer.parseInt(st.nextToken());

			sixmin = Math.min(sixmin, six);
			onemin = Math.min(onemin, one);
		}

		ans += Math.min(sixmin, onemin * 6) * (N / 6);
		ans += Math.min(sixmin, onemin * (N % 6));

		System.out.println(ans);
	}
}