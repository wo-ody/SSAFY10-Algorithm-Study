import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int t;
	static int m, n, x, y;
	static int answer;

	public static void main(String[] args) throws IOException{
		t = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken()) - 1;
			y = Integer.parseInt(st.nextToken()) - 1;
			
			boolean flag = false;

            for (int k = x; k < lcm(m, n); k += m)
                if (k % n == y) { // k가 M과 N의 조건을 동시에 만족하는지 확인
                    System.out.println(k + 1); // 1부터 시작하는 해를 출력하기 위해 +1
                    flag = true;
                    break;
                }

            if (!flag)
                System.out.println(-1);
		}
	}
	
	public static int gcd(int a, int b) {
        if(a % b == 0)
        	return b;
        return gcd(b, a % b);
    }

    public static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}
