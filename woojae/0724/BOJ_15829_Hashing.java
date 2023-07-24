import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int l = sc.nextInt();
		String str = sc.next();
		long h = 0;
		long pow = 1;
		int m = 1234567891;
		
		for (int i = 0; i < l; i++) {
			h += ((long)str.charAt(i) - 96) * pow;
			pow = (pow * 31) % m;  // 반복할수록 31을 곱함으로써 r^i 구현, pow의 범위를 제한하기 위해 매번 m으로 나눈 나머지를 사용
		}
		System.out.println(h % m);
	}
}
