import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] x = Integer.toBinaryString(Integer.parseInt(br.readLine())).toCharArray();
		int ans = 0;
		for (char c : x) {
			if (c=='1') ans++;
		}
		System.out.println(ans);
	}
}
