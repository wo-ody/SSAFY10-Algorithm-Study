import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//다음 대결 순번은 (현재의 수+1)/2
//지민과 한수의 순번이 같아진다면 그 전이 둘의 대결 라운드
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, jimin, hansoo, round;

	public static void main(String[] args) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		jimin = Integer.parseInt(st.nextToken());
		hansoo = Integer.parseInt(st.nextToken());

		while (jimin != hansoo) {
			round++;
			jimin = (jimin + 1) / 2;
			hansoo = (hansoo + 1) / 2;
		}
		System.out.println(round);
	}
}