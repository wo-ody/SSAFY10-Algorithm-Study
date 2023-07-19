import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int A = sc.nextInt();
			int B = sc.nextInt(); //입력
			int MA = A;
			int MB = B;           //곱해준 값 저장 변수
			int i = 2, j = 2;     //곱해주는 수

			while (MA != MB) {
				if (MA > MB) {
					MB = B * j;
					j++;
				} else {
					MA = A * i;
					i++;
				}
			}                     //배수가 같아질 때까지 반복
			System.out.println(MA); //출력
		}

	}
}
