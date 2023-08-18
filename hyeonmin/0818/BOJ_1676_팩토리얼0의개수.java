import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_1676_팩토리얼0의개수 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		// 0 <= N <= 500
		
		int count = 0;
		long num = 1;
		for (long i = 1; i <= N; i++) {
			num *= i;
			
			// 현재 자릿수가 0인가? -> 자릿수 올림(땡김) and 0카운트++
			if(num % 10 == 0) {
				// 0이 두번 나올 때도 있음
				while( num%10 == 0) {
					num /= 10;
					count++;
				}
			}
			
			// 0이 두번 나올 수 도 있기 때문에 넉넉하게 남겨놓음
			num = num % 1000;
		}
		bw.write(count+"");
		bw.flush();
	}
}
