import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int series = 0;
		int answer = 0;
		
		while(true) {
			if(String.valueOf(series).contains("666")) {  // 숫자가 갱신되면서 시리즈에 포함되면
				answer++;  // 정답 갱신
				if(answer == n) break;  // 정답이 찾고자 하는 시리즈에 해당하면 종료
			}
			series++;  // 원하는 시리즈를 찾기까지 갱신
		}
		System.out.println(series);
	}
}
