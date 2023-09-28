import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
public class BOJ_1541_잃어버린_괄호 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sum = Integer.MAX_VALUE;
		StringTokenizer st = new StringTokenizer(br.readLine(), "-");
 
		while (st.hasMoreTokens()) {
			int temp = 0;
			StringTokenizer st2 = new StringTokenizer(st.nextToken(), "+");
			
			// 덧셈으로 나뉜 토큰들을 모두 더한다. 
			while (st2.hasMoreTokens()) {
				temp += Integer.parseInt(st2.nextToken());
			}
			
			// 첫 번째토큰인 경우 temp값이 첫 번째 수가 됨
			if (sum == Integer.MAX_VALUE) {
				sum = temp;
			} else {
				sum -= temp;
			}
		}
		System.out.println(sum);
	}
 
}
