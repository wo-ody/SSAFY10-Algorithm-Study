import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//암호로 된 문자의 개수를 센 후
//문자열의 문자 각각의 개수와 맞는지를 확인한다.
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] count = new int[53];//문자 개수 카운트용
	static int N;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			count[Integer.parseInt(st.nextToken())]++;
		}

		String s = br.readLine();

		for (int i = 0; i < s.length(); i++) {
			int temp = s.charAt(i);

			//공백
			if (temp == 32) {
				count[0]--;
				if (count[0] < 0) {
					System.out.println("n");
					return;
				}
			}

			//대문자
			if (temp >= 65 && temp <= 90) {
				count[temp - 64]--;
				if (count[temp - 64] < 0) {
					System.out.println("n");
					return;
				}
			}

			//소문자
			if (temp >= 97 && temp <= 122) {
				count[temp - 70]--;
				if (count[temp - 70] < 0) {
					System.out.println("n");
					return;
				}
			}
		}
		System.out.println("y");
	}
}