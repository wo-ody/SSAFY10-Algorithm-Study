import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1110_더하기사이클 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());


		int a = N/10;
		int b = N%10;
		int count = 1;
		int sum = a+b;
		
		a = b;
		b = sum%10;

		while( N != a*10+b ) {
			sum = a+b;
			a = b;
			b = sum%10;
			count++;
		}
		System.out.println(count);
	}
}	
