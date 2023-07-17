import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] num = new int[N]; // N만큼 배열 생성
		int max = 0;
		double sum = 0; //

		for (int k = 0; k < N; k++) {
			num[k] = sc.nextInt();

		} // 배열 입력

		for (int i : num) {
			if (i > max) {
				max = i;

			}
		} // 입력된 수 중 최대값 찾기

		for (int j : num) {

			sum += (double) j / max * 100.0;

		} // 각 점수 계산해서 더하기
		System.out.println(sum / N); // 평균 출력
	}

}
