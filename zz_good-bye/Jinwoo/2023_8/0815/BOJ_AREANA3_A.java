import java.io.*;
// 몬티홀 문제가 나왔다
// 그 뒤도 전부 수학문제.. 몹시어려움
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<n; i++) sb.append("swimming ");
		System.out.println(sb);
		System.out.flush();
		sb = new StringBuilder();
		String[] st = br.readLine().split(" ");
		for (int i=0; i<n; i++) sb.append(st[i].equals("bowling")?"soccer ":"bowling ");
		System.out.println(sb);
	}
}
