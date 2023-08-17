import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int hex = 6;  // 벌집의 수
		int target = 2; // 최소 시작 위치
		int layer = 1;  // 층의 수 -> 정답
		// 층은 넓어질수록 6의 배수 형태로 증가
		if(n != 1)
			while(target <= n) {
				target += hex * layer;  // 최소 위치 갱신
				layer++;  // 층 갱신
			}
		System.out.println(layer);
		// 2층 6개의 집, 최소의 시작 위치는 2 = target
		// 3층 12개의 집, 최소의 시작 위치는 8
		// 4층 18개의 집, 최소의 시작 위치는 20
		// 5층 24개의 집, 최소의 시작 위치는 38
		// target이 n보다 커졌다는 것은 다른 층으로 이동되었다는 것을 의미
		// 코드 작성 순서에 따라 종료 조건을 검사할 때, layer는 직전의 layer를 가리킴
	}
}
