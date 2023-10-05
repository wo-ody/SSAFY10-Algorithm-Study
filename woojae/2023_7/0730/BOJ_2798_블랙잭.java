import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] arr = new int[n];
		int temp = 0;
		int answer = 0;
		
		for(int i = 0; i < n; i++)
			arr[i] = sc.nextInt();
		
		for(int i = 0; i < n; i++) {  // 모든 카드의 경우의 수에 대해 탐색
			for(int j = i + 1; j < n; j++) {  // 첫 번째 선택된 카드의 다음 카드
				for(int k = j + 1; k < n; k++) {  // 두 번째 선택된 카드의 다음 카드
					temp = arr[i] + arr[j] + arr[k];  // 3개의 카드를 확인
					if(temp <= m)  // 3개의 카드의 합이 m이하면
						answer = (temp > answer) ? temp : answer;  // 현재 정답보다 큰지 확인한 후, 클 경우 갱신
				}
			}
		}
		System.out.println(answer);
	}
}
