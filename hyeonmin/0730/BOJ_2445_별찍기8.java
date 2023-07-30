import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_2445_별찍기8 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N-1; i++) {
			for (int j = 0; j < i+1; j++) {
				bw.write("*");
			}
			for (int j = 0; j < (N-i-1)*2; j++) {
				bw.write(" ");
			}
			for (int j = 0; j < i+1; j++) {
				bw.write("*");
			}
			bw.write("\n");
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = i; j < N; j++) {
				bw.write("*");
			}
			for (int j = 0; j < i*2; j++) {
				bw.write(" ");
			}
			for (int j = i; j < N; j++) {
				bw.write("*");
			}
			bw.write("\n");
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
}
