import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_4153_직각삼각형 {
	static String answer;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if(a == 0 && b == 0 && c == 0) break;
			
			if(isPytha(a, b, c) || isPytha(a, c, b) || isPytha(b, c, a)) {
				answer = "right";
			} else {
				answer = "wrong";
			}
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}
	static boolean isPytha(int n1, int n2, int n3) {
		return n1*n1 + n2*n2 == n3*n3;
	}

}
