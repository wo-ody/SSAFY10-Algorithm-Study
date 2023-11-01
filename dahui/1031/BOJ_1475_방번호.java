import java.util.Scanner;

public class BOJ_1475_방번호 {
	static int[] num = new int[10];
	static int room;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		room = sc.nextInt();

		while (room > 0) {
			int i = room % 10;
			num[i]++;
			room /= 10;
		}

		int max = 1;
		for (int i = 0; i < 10; i++) {
			if (num[i] > max) {
				if (i == 6 || i == 9) {
					max = Math.max(max, (num[6] + num[9] + 1) / 2);
				} else
					max = num[i];
			}
		}
		System.out.println(max);
	}
}
