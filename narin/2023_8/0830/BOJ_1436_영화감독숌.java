import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int count = 0;

		for (int i = 666; i < 666666666; i++) {
			if (String.valueOf(i).contains("666"))
				count++;
			if (count == N) {
				String result = String.valueOf(i);
				System.out.println(result);
				break;
			}
		}
	}
}
