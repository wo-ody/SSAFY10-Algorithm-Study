import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();

		String result = Integer.toString(A * B * C);
		int[] count = new int[10];

		for (int i = 0; i < result.length(); i++) {
			for (int j = 0; j < 10; j++) {
				if (result.charAt(i) - '0' == j)
					count[j]++;
			}
		}

		for (int i = 0; i < 10; i++) {
			System.out.println(count[i]);
		}
	}

}
