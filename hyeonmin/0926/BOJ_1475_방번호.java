import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_1475_방번호 {

	static String N;
	static int ans = Integer.MIN_VALUE;
	static int[] set = new int[10];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = br.readLine();
		
		for (int i = 0; i < N.length(); i++) {
			set[ N.charAt(i)-'0' ]++;
		}
		int sum = set[6]+set[9];
		
		// 6과 9의 개수 합이 홀수 이면 세트가 하나 더 필요하기 때문에 더하기 1
		int same = sum % 2 == 0 ? sum / 2 : sum / 2 + 1;
		
		// 갱신
		set[6] = set[9] = same;
		
		for( int s : set ) {
			ans = Math.max(ans, s);
		}
		
		br.close();
		bw.write(ans+"");
		bw.flush();
	}
}
