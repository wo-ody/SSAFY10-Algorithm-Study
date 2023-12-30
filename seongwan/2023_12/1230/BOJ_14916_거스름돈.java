import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, five, temp;

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());

		five = N / 5;
		temp = N % 5;
		if (temp % 2 == 0)// 5원짜리로 다 나눠지는 경우
			System.out.println(five + temp / 2);
		else {
			while (true) {
				five--;
				if (five == -1) {// 거스를 수 없는 경우
					System.out.println(-1);
					break;
				}
				temp = N - 5 * five;
				if (temp % 2 == 0) {
					System.out.println(five + temp / 2);
					break;
				}
			}
		}
	}
}