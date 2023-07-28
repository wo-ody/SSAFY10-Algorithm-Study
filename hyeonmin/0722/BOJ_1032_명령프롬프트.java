import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1032_명령프롬프트 {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		char[] result = br.readLine().toCharArray();
		
		for (int i = 1; i < N; i++) {
			char[] c = br.readLine().toCharArray();
			for (int j = 0; j < result.length; j++) {
				if(result[j] != c[j]) result[j]='?';
			}
		}
		System.out.println(result);
		
	}

}
