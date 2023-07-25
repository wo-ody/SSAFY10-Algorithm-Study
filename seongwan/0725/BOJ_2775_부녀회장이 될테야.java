import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[15][14]; // 0~14층 1호~14호([][0]부터 1호 시작)
		for (int i = 0; i < 14; i++) {
			arr[0][i] = i + 1; // 0층 사람

		}
		for (int i = 1; i < 15; i++) {
			arr[i][0] = 1; // 1호 사람 =1
			for (int j = 1; j < 14; j++) {
				arr[i][j] = arr[i - 1][j] + arr[i][j - 1]; // 각 호실 마다 사람 수 계산

			}
		}
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int k = sc.nextInt(); // 층
			int n = sc.nextInt(); // 호수
			System.out.println(arr[k][n - 1]);

		}
	}

}
