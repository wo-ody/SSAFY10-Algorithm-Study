import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int x1, y1, x2, y2, x3, y3, x4, y4;

	public static void main(String[] args) throws Exception {
		// 선분 1입력
		st = new StringTokenizer(br.readLine());
		x1 = Integer.parseInt(st.nextToken());
		y1 = Integer.parseInt(st.nextToken());
		x2 = Integer.parseInt(st.nextToken());
		y2 = Integer.parseInt(st.nextToken());

		// 선분 2입력
		st = new StringTokenizer(br.readLine());
		x3 = Integer.parseInt(st.nextToken());
		y3 = Integer.parseInt(st.nextToken());
		x4 = Integer.parseInt(st.nextToken());
		y4 = Integer.parseInt(st.nextToken());

		// 각 선분에서 다른 선분의 점까지의 두 ccw의 곱이 둘 다 <=0이라면 선분 교차
		// 둘 다 0인데 선분의 끝과 끝이 이어져 있지 않다면 선분 교차x
		int a = ccw(x1, y1, x2, y2, x3, y3);
		int b = ccw(x1, y1, x2, y2, x4, y4);
		int c = ccw(x3, y3, x4, y4, x1, y1);
		int d = ccw(x3, y3, x4, y4, x2, y2);

		if (a * b <= 0 && c * d <= 0) {
			if (a * b == 0 && c * d == 0)
				if (Math.min(x1, x2) <= Math.max(x3, x4) && Math.min(x3, x4) <= Math.max(x1, x2)
						&& Math.min(y1, y2) <= Math.max(y3, y4) && Math.min(y3, y4) <= Math.max(y1, y2))
					System.out.println(1);
				else
					System.out.println(0);
			else
				System.out.println(1);
		} else
			System.out.println(0);

	}

	static int ccw(long x1, long y1, long x2, long y2, long x3, long y3) {
		long result = x1 * y2 + x2 * y3 + x3 * y1 - (x2 * y1 + x3 * y2 + x1 * y3);
		if (result > 0)
			return 1;// 반시계
		else if (result == 0)
			return 0;// 같은 직선 상에 존재
		else
			return -1;// 시계
	}
}