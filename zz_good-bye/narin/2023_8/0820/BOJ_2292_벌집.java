import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int count = 1, i = 0;

		while (true) {
			N -= 6 * i;
			if (N <= 1) {
				break;
			}
			i++;
			count++;

		}
		System.out.println(count);
	}
}
