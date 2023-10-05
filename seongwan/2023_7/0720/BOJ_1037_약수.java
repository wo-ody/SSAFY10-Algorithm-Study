import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = sc.nextInt();
		int m = 0;
		int M = 0;
		int chk = 0;
		for (int i = 0; i < cnt; i++) {
			chk = sc.nextInt();
			if (i == 0) {
				m = chk;
				M = chk;
			}              

			if (chk < m) {
				m = chk;
			} else if (chk > M) {
				M = chk; // 입력 받은 수 중 최대와 최소 구하기
			}
		}
		System.out.println(m * M); // 약수의 최대와 최소를 곱해 원래의 수 출력
	}

}
