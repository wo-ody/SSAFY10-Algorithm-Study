import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class BOJ_1181_단어정렬 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		String[] A = new String[N];
		for (int i = 0; i < N; i++) {
			A[i] = br.readLine();
		}
		Arrays.sort(A, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if(o1.length() == o2.length()) return o1.compareTo(o2);
				else return o1.length()-o2.length();
			}
		});
		
		// 배열출력
		bw.write(A[0]+"\n");
		for (int i = 1; i < N; i++) {
			if(A[i].equals(A[i-1])) continue;
			bw.write(A[i]+"\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}

}
