import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_25193_곰곰이의식단관리 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		String str = br.readLine();
		int cCnt = 0;
		for (int i = 0; i < N; i++) {
			if (str.charAt(i) == 'C') cCnt++;
		}
		int cnt = N-cCnt+1;

		int a = cCnt / cnt;
		int b = cCnt % cnt;

		if (b != 0)
			System.out.println(a +1);
		else
			System.out.println(a);
	}
}
