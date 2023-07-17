package acmicpc.step3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class L3_11021 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String s = br.readLine();
			int A = Integer.parseInt(s.split(" ")[0]);
			int B = Integer.parseInt(s.split(" ")[1]);
			// bw.write("Case #" + tc + ": " + (A + B) + "\n");
			bw.write("Case #" + tc + ": " + A + " + " + B + " = " + (A + B) + "\n");
		}

		bw.flush();
	}

}
