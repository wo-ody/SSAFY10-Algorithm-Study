import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int T;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int total = 0;
			int num = Integer.parseInt(br.readLine());
			int temp = 0;
			int count = 0;
			while (total != 1023) {
				count++;
				temp = num * count;
				while (temp >= 1) {
					total = total | (1 << (temp % 10));
					temp /= 10;
				}
			}
			sb.append("#" + t + " " + count * num + "\n");
		}
		System.out.println(sb);
	}
}
