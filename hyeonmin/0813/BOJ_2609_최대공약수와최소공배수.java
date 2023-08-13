import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2609_최대공약수와최소공배수 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int g = gcd(a,b);
		int l = a * b / g;
		System.out.println(g +"\n" + l);
	}
	private static int gcd(int a, int b) {
		if(b==0) return a;
		return gcd(b, a%b);
	}
}
