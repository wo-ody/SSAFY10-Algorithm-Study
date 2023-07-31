import java.util.Scanner;
public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		long first = 1;
		long second = 1;
		long res = 0;
		
		if (N < 3) {
			res = 1;
		}else {
			for(int i=2; i<N; i++) {
				res = first+second;
				first = second;
				second = res;
			}
		}
		System.out.println(res);
		
		sc.close();
	}

}
