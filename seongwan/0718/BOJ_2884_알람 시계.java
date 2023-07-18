import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int H = sc.nextInt();
		int M = sc.nextInt(); // H,M 입력
		M -= 45; // 45분 감소
		if (M < 0) {
			M += 60;
			H -= 1;
			if (H < 0) {
				H += 24;

			}

		} // 시간 경계에서 조건문
		System.out.printf("%d %d", H, M); //출력
	}

}