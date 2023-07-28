import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] mod = new int[10]; // 나머지 저장할 배열
		int cnt = 0; // 나머지로 나온 수 카운트
		for (int i = 0; i < 10; i++) {
			int A = sc.nextInt();
			mod[i] = A % 42; 
		}                   //수 입력받고 42로 나눈 나머지 배열에 저장

		for (int i = 0; i < 42; i++) {
			for (int j : mod) {
				if (i == j) {
					cnt += 1;
					break; //같은 값 2번 체크 방지

				}

			}

		}                 //0~41에서 배열에 있는 값과 일치하면 카운트하고 다음 수로 넘어감
		System.out.println(cnt);
	}
}
