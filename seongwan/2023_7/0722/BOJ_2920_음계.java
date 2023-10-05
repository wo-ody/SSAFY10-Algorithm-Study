import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] Arr = new int[8];
		int chk = 0;

		for (int i = 0; i < 8; i++) {
			Arr[i] = sc.nextInt(); // 음계 입력

		}
		chk = Arr[0];// 첫 음계를 chk에 할당
		if (chk == 1) { // 첫 음계가 1인 경우
			for (int i = 0; i < 8; i++) {
				if (Arr[i] == chk) {
					if (chk == 8) {
						System.out.println("ascending");

					} // 8까지 순서대로 진행된 경우
					chk++; // chk를 순서대로 음계와 비교하기 위해 증가
				} else {
					System.out.println("mixed");
					break;
				} // 중간에 다른 수가 나오는 경우

			}
		} else if (chk == 8) { // 첫 음계가 8인 경우
			for (int i = 0; i < 8; i++) {
				if (Arr[i] == chk) {
					if (chk == 1) {
						System.out.println("descending");

					}
					chk--;

				} else {
					System.out.println("mixed");
					break;
				}
			}

		} else
			System.out.println("mixed"); // 첫 음계가 1,8이 아닌 경우

	}
}
