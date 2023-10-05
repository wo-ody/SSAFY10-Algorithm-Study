import java.util.Scanner;

public class Main {
	private static int N;
	private static int[] num, target;
	private static boolean[] isSelected;

	private static void Permutation(int idx) {

		if (idx == N) {
			for (int i = 0; i < N; i++) {
				System.out.print(target[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!isSelected[i]) {
				target[idx] = num[i];
				isSelected[i] = true;
				Permutation(idx + 1);
				isSelected[i] = false;
			}
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		num = new int[N];
		target = new int[N];
		isSelected = new boolean[N];

		for (int i = 0; i < N; i++)
			num[i] = i + 1;

		Permutation(0);
	}
}
