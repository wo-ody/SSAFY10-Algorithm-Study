import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] S = br.readLine().toCharArray();
		char[] T = br.readLine().toCharArray();
		
		// T -> S로 바꿀 수 있으면 res = 1
		// T -> S로 바꿀 수 없으면 res = 0
		int res = 1;
		int start = 0;
		int end = T.length-1;
		boolean reversed = false;

		
		
		int len = T.length-S.length;
		// 자리수 차이 만큼 반복
		for(int i=0; i<len; i++) {
			// T의 마지막 문자가 A인 경우 처리
			if(T[end] == 'A') {
				// 뒤쪽 접근 범위 줄이기
				if(reversed) end++;
				else end--;
				
				
			// T의 마지막 문자가 B인 경우 처리
			}else {
				// 뒤쪽 접근 범위 줄이기
				if(reversed) end++;
				else end--;
		
				// 문자열 뒤집기
				int tmp=end;
				end = start;
				start = tmp;
				reversed = !reversed;
			}
		}
		
		
		// 문자열 만들기
		String str = "";
		if(reversed) {
			for(int i=start; i>=end; i--) {
				str += Character.toString(T[i]);
			}
		}else {
			for(int i=start; i<=end; i++) {
				str += Character.toString(T[i]);
			}
		}

		// 값 비교해서 다르면 0
		if(!(String.valueOf(S).equals(str))) {
			res = 0;
		}
		
		// 결과 출력
		System.out.println(res);
	}

}
