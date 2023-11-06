import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int N;
	static int num = 9;
	static int[] alphabet = new int[26];
	static int[] weight = new int[26];
	
	static String[] inputs;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 값 입력 받기
		N = Integer.parseInt(br.readLine());
		inputs = new String[N];
		int lengthMax = 0;
		for (int i = 0; i < N; i++) {
			inputs[i] = br.readLine();
			lengthMax = Math.max(lengthMax, inputs[i].length());
		}
		
		// 단어의 각 문자의 가중치 계산
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < lengthMax; i++) {
			for (int j = 0; j < N; j++) {
				String word = inputs[j];
				if (word.length() > i) {
					weight[word.charAt((word.length() - 1) - i)-'A'] += (int)Math.pow(10, i);
				}
			}
		}

		// 각 문자 값 계산
		grantNum();
		
		// 결과 계산
		int answer = 0;
		
		for (int i = 0; i < N; i++) {
			answer += getValue(inputs[i], inputs[i].length()-1);
		}

		// 결과 출력
		System.out.println(answer);
	}

	// character에 값 부여 9 -> 0
	static void grantNum() {
		int[] tmp = new int[26];
		for(int i=0; i<26; i++) {
			if(weight[i] != 0) tmp[i] = weight[i];
		}
		
        // 가중치 오름차순 정렬
		Arrays.sort(tmp);
		
		for (int i=25; i>= 0; i--) {
			if(tmp[i] == 0) break;
			
			for(int j=0; j<26; j++) {
				if(alphabet[j] != 0) continue; 
				if(tmp[i] == weight[j]) {
					alphabet[j] = num--;
					break;
				}
			}
		}
	}

	// 단어에 해당하는 값 계산하여 반환.
	static int getValue(String str, int size) {
		int result = 0;
		for (int i = size; i >= 0; i--) {
			result += alphabet[str.charAt(i) - 'A'] * ((int) Math.pow(10, size - i));
		}
		return result;
	}
}
