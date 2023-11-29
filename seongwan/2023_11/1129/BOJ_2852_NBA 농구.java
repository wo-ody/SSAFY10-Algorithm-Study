import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, A, B, Ah, h, m, Am, Bh, Bm, ph, pm;// 골 수,A,B점수 A팀 이긴 시간,분 B팀 이긴 시간,분, 앞 입력의 시간,분
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int goal = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(st.nextToken(), ":");
			h = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			if (A > B) {
				Ah += h - ph;
				Am += m - pm;
			} else if (B > A) {
				Bh += h - ph;
				Bm += m - pm;
			}
			if (goal == 1)
				A++;
			else
				B++;
			ph = h;
			pm = m;
		}
		h = 48;
		m = 0;
		if (A > B) {
			Ah += h - ph;
			Am += m - pm;
		} else if (B > A) {
			Bh += h - ph;
			Bm += m - pm;
		}

		while (Am < 0) {
			Am += 60;
			Ah--;
		}
		while (Bm < 0) {
			Bm += 60;
			Bh--;
		}
		Ah += Am / 60;
		Am %= 60;

		Bh += Bm / 60;
		Bm %= 60;

		System.out.printf("%02d:%02d\n", Ah, Am);
		System.out.printf("%02d:%02d\n", Bh, Bm);

	}

}