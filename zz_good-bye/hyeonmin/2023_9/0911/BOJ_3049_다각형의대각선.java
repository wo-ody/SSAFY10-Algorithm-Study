import java.util.Scanner;

public class BOJ_3049_다각형의대각선 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		// 3 ~ N ~ 100
		
		// 다각형의 대각선의 개수 n(n-3)/2
		// nC4
		// = n*(n-1)*(n-2)*(n-3) / (4*3*2*1 == 24)
		System.out.println(N*(N-1)*(N-2)*(N-3)/24);
		
	}

}
