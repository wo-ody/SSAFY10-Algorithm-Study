import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		for (int t = 0; t < N; t++) {
			int cnt = 0; // 연속된 O 개수 체크
			int sum = 0; // 점수 합산
			String s = sc.next();   
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == 'O') {
					cnt++;   //O가 나올 때마다 증가
					sum += cnt;
				} else {
					cnt = 0;  //X가 나올 때 연속된 O개수 0으로 초기화
				}

			}
			System.out.println(sum);   //점수 합 출력
		}
	}

}
