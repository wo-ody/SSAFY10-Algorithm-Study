import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(solve(n));
	}
	
	static int solve(int n) {
		int answer = 0;
		int len = 0;
		BigInteger [] dp = new BigInteger[n + 1];  // n이 커질수록 정수값이 터무니없이 커지기 때문에 BigInteger 사용
		dp[0] = BigInteger.valueOf(1);  // BigInterger 타입의 정수 1을 선언하는 방법
		for(int i = 1; i < n + 1; i++) dp[i] = dp[i-1].multiply(BigInteger.valueOf(i));  // 해당 타입은 일반적인 연산자는 사용할 수 없고 제공하는 메서드를 통해 연산 가능함
		char[] temp = dp[n].toString().toCharArray();  // 마지막 값을 문자열로 변환 후, 문자 배열로 최종 변환
		
		len = temp.length;
		for(int i = len - 1; i > -1; i--) {  // 뒤에서부터 탐색하며
			if(temp[i] == '0')  // 0을 발견할 때마다 정답 갱신
				answer++;
			else  // 처음 0이 아닌 값을 만났다면
				break;  // 반복 종료
		}
		return answer;
	}
}
