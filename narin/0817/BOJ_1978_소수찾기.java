import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] num = new int[N];
		int count = 0;

		for (int i = 0; i < N; i++) {
			num[i] = sc.nextInt();
			int sum = 0;
			for (int j = 1; j <= num[i]; j++) {
				if (num[i] % j == 0) {
					sum += j;
				}
			}
			if (sum == 1 + num[i]) {
				count++;
			}
		}
		System.out.println(count);
	}
}
