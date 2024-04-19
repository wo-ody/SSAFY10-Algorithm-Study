import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.BitSet;
import java.util.StringTokenizer;

public class BOJ_17176_암호해독기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[53];
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[num]++;
		}
		String str = br.readLine();
		//영 대문자 65~90, 소문자 97~122
		boolean flag = true;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c == ' ') {
				arr[0] --;
			}else if (c >= 65 && c <= 90){
				arr[c - 64]--;
			}else {
				arr[c - 70]--;
			}
		}
		for (int i=0; i<arr.length; i++) {
			if (arr[i] != 0) {
				flag = false;
				break;
			}
		}

		if (flag) System.out.println("y");
		else	System.out.println("n");
	}
}
