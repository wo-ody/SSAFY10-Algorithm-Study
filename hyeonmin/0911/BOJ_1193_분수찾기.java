import java.util.Scanner;

public class BOJ_1193_분수찾기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int X = sc.nextInt();
		
		// 대각선으로 찾는다
		
		// 1/1 1/2 2/1 1/3 2/2 3/1
		int cnt = 1;
		int a = 1;
		while(true) {
			
			cnt += a++;
			if(cnt > X) {
				if(a % 2 != 0) {
					System.out.println( (a - (cnt-X)) + "/" + (a - (a - (cnt-X))) );
				} else {
					System.out.println( (a - (a - (cnt-X))) + "/" +  (a - (cnt-X)) );
				}
				break;
			}
		}
	}

}
