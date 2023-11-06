import java.util.Scanner;

public class Main {
	static int N,ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		if(N<=99) ans = N;
		else {
			ans = 99;
			for(int i=100; i<=N; i++) {
				int first = i / 100;
				int second = i%100 /10;
				int third = i%10;
				
				if(second-first == third-second) ans++;
			}
		}
		
		System.out.println(ans);
	}

}
