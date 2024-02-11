import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int height = sc.nextInt();
			int width = sc.nextInt();
			int guest = sc.nextInt();

			int floor = guest % height, room = guest / height;
			if (floor == 0)
				System.out.println(height * 100 + room);
			else
				System.out.println(floor * 100 + room + 1);
		}
	}

}
