import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_10809_알파벳찾기 {

	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
//		
//		// alphabet의 idx를 저장할 배열
//		int[] ans = new int[26];
//		
//		// 받은 문자열
//		char[] arr = br.readLine().toCharArray();
//		// 인덱스를 못찾은 경우  -1 출력하기 위해 default 값  -1로 설정
//		Arrays.fill(ans, -1);
//		
//		// 문자들의 인덱스를 돌면서 확인하기
//		for (int i = 0; i < arr.length; i++) {
//			
//			// idx배열의 인덱스에 현재 문자 위치 값을 저장하기 위해 cur 변수 사용
//			int cur = arr[i] -'a';
//			
//			// idx배열에 아직 문자 갱신을 한적이 없으면 idx배열에 값 갱신
//			if(ans[cur] < 0 || ans[cur] > cur) ans[cur] = i;
//		}
//		
//		for (int x : ans) {
//			sb.append(x).append(" ");
//		}
//		sb.setLength(sb.length()-1);
//		System.out.println(sb);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String input = br.readLine();

		for (char c = 'a'; c <= 'z'; c++) {
			sb.append(input.indexOf(c)).append(" ");
		}

		bw.write(sb.append("\n").toString());
		bw.flush();
		bw.close();
		br.close();

	}

}
