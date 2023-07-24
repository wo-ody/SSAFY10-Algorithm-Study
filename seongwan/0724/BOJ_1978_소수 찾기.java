import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt = 0;
		int[] arr = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31 };
		for (int i = 0; i < N; i++) {
			int x = sc.nextInt();
			for (int j = 0; j < 11; j++) {
				if (x == arr[j]) {
					cnt++;
					break;
				} else if (x % arr[j] == 0 || x == 1) {
					break;

				} else if (j == 10) {
					cnt++;

				}

			}

		}
		System.out.println(cnt);
	}
}