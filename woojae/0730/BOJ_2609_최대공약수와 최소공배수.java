import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int gcd = cal_gcd(a, b);  // 유클리드 호제법으로 최대공약수 계산
		int lcm = (a * b) / gcd ;  // 주어진 수들의 곱을 최대공약수로 나누면 최대공배수
		System.out.println(gcd);
		System.out.println(lcm);
	}
	
	static int cal_gcd(int a, int b) {
		if(b == 0)  // 나머지가 0이라면
			return a;  // 몫 반환
		return cal_gcd(b, a % b);
	}
}
