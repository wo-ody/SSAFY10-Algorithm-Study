import java.util.Scanner;

public class BOJ_11720_숫자의합 {

	public static void main(String[] args) {
		
		// N의 최대 범위, 즉 bigO를 확인하고 풀이를 진행해야 한다.
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		String sNum = sc.next();
		char[] cNum = sNum.toCharArray();
		int sum = 0;
		
		for (int i=0; i<cNum.length; i++) {
			sum += cNum[i] - '0';
		}
		System.out.println(sum);
		

	}

}
