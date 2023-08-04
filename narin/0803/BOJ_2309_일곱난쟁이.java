import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] height = new int[9];
		int sum = 0;

		for (int i = 0; i < height.length; i++) {
			height[i] = sc.nextInt();
			sum += height[i];
		}

		Arrays.sort(height);

		boolean find = false;
		for (int i = 0; i < height.length; i++) {
			for (int j = i + 1; j < height.length; j++) {
				if (sum - height[i] - height[j] == 100) {
					height[i] = 0;
					height[j] = 0;
					find = true;
				}
				if (find == true)
					break;
			}
			if (find == true)
				break;
		}

		for (int i = 0; i < height.length; i++) {
			if (height[i] != 0)
				System.out.println(height[i]);
		}

		sc.close();
	}
}
