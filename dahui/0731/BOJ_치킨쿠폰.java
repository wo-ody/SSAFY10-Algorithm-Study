import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//입력횟수가 주어지지 않는 문제! 예외 처리!
//문자열 변수에 입력을 주고 null체크를 한다.
public class BOJ1673 {

	public static void main(String[] args) throws IOException {
		solution(new BufferedReader(new InputStreamReader(System.in)));

	}
	
	private static void solution(BufferedReader br) throws IOException //예외처
	{
		String inputStr = " ";
		while((inputStr = br.readLine()) != null){ //문자열 null 체크  
			System.out.println(getChickens(new StringTokenizer(inputStr)));
		}
		
		br.close();
	}
	
	private static int getChickens(StringTokenizer st) {
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int result = n;
		while(n/k != 0) { //쿠폰으로 치킨을 먹어도 치킨에 따라 도장을 추가해줘야한다.
			result += n/k;
			n = n/k + n%k;
		}
		
		return result;
		
	}
}
