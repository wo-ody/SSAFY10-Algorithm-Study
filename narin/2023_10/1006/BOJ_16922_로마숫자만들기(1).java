import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

	private static int N, sum;
	private static Set<Integer> set;
	private static int[] roma = { 1, 5, 10, 50 };
	private static int[] result;

	private static void comb(int index, int count) {
		if (count == N) {
			sum = 0;
			for (int n : result) {
				sum += n;
			}
			set.add(sum);
			return;
		}

		for (int i = index; i < 4; i++) {
			result[count] = roma[i];
			comb(i, count + 1);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		set = new HashSet<>();

		result = new int[N];

		comb(0, 0);

		System.out.println(set.size());
	}
}
