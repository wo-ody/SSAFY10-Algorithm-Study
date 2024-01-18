import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//2*W 보다 S가 큰 상황이면 (X+Y)*W 가 답 ->대각선으로 가는 게 가로+세로로 가는 것보다 비용이 더 크므로
//W<S<2*W인 상황이면 X,Y중 작은 값까지는 S로 큰 값에서 작은 값을 뺀 값까지는 W로 이동
//-> 대각선으로 가는게 가로,세로 보다는 저렴하지만 가로나 세로방향으로 가야할 때 대각선으로 이동하는 것은
//가로,세로로 그냥 가는 것보다 비용이 더 많이 들어가므로
//W>S인 상황 X,Y의 값 중 작은 값까지 S로 이동한 후 남은 값은 짝수라면 남은값*S 홀수라면 (남은값-1)*S +W
//->대각선으로 이동하고 가로나 세로 방향만 남았어도 대각선으로 지그재그로 이동하는 게 더 비용이 저렴하므로

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static long X, Y, W, S, ans;

	public static void main(String[] args) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());

		X = Long.parseLong(st.nextToken());
		Y = Long.parseLong(st.nextToken());
		W = Long.parseLong(st.nextToken());
		S = Long.parseLong(st.nextToken());

		if (S >= 2 * W) {
			ans = (X + Y) * W;
		} else if (W > S) {
			ans = Math.min(X, Y) * S + //
					(Math.abs(X - Y) % 2 == 1 ? (Math.abs(X - Y) - 1) * S + W : Math.abs(X - Y) * S);
		} else {
			ans = Math.min(X, Y) * S + Math.abs(X - Y) * W;
		}
		System.out.println(ans);
	}
}