import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt = 0;    //소수 개수
		int[] arr = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31 }; 
		// 소수 판정 배열 31^2=961,37^2=1369 1000이하의 자연수이므로 31까지
        for (int i = 0; i < N; i++) {
			int x = sc.nextInt();  
			for (int j = 0; j < 11; j++) {
				if (x == arr[j]) { //배열 안의 수는 소수이므로 카운트
					cnt++;
					break;
				} else if (x % arr[j] == 0 || x == 1) {//배열 안의 수로 나누어지거나 1이면 노카운트
					break;

				} else if (j == 10) {//배열을 다 돌았을 때까지 나누어지지 않으면 카운트
					cnt++;

				}

			}

		}
		System.out.println(cnt);//소수 개수 출력
	}
}