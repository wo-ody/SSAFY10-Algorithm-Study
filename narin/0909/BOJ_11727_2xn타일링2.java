import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[] arr = new int[1001];

		arr[1] = 1;
		arr[2] = 3;
		for (int i = 3; i <= n; i++) {
			arr[i] = (arr[i - 1] + 2 * arr[i - 2]) % 10007;
		}

		System.out.println(arr[n]);
	}
}
