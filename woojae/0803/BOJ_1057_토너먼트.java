import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		double kim = sc.nextFloat();
		double lim = sc.nextFloat();
		int cnt = 0;
		
		while(kim != 1 || lim != 1) {  // 최소 둘 중 하나가 1등이 될 때까지
			kim = Math.ceil(kim / 2);  // 다음 순위로, 홀수는 반올림
			lim = Math.ceil(lim / 2);
			cnt++;  // 라운드 진행 횟수 갱신
			if(kim == lim)  // 같은 라운드에서 만나면
				break;
		}
		System.out.println((kim == lim) ? cnt : -1);
	}
}
