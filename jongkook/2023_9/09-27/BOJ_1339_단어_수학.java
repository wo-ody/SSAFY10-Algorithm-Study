import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class BOJ_1339_단어_수학 {
	static String[] beNumbers;
	static int T;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		beNumbers = new String[T];
		for(int t = 0; t < T; t++) beNumbers[t] = br.readLine();	
		Arrays.sort(beNumbers);
		System.out.println(numeric());

	}
	
	static void getSameLength() {
		int max = beNumbers[0].length();
		for(int i = 1; i < T; i++) {
			int start = beNumbers[i].length();
			for(int j = start; j < max; j++) {
				beNumbers[i] = "," + beNumbers[i];
			}
		}
	}
	
	static int numeric() {
		getSameLength();
		
		ArrayList<Character> lst = new ArrayList<>();
		HashMap<Character, Integer> map = new HashMap<>();
		
		int len = beNumbers[0].length();
		
		for(int i = 0; i < len; i++) {			
			for(int j = 0; j < T; j++) {
				String str = beNumbers[j];
				char alpha = str.charAt(i);
				// map 에는 현재 몇번 중첩되었는지 알 수 있다.
				// lst 에는 순서가 있다
				if(!lst.contains(alpha) && alpha != ',') {
					lst.add(alpha);
					map.put(alpha, 10 - lst.size());
				}
			}			
			
		}
		int result = 0;
		
		for(int i = 0; i < T; i++) {
			String str = "";
			for(int j = 0; j < beNumbers[i].length(); j++) {
				if(beNumbers[i].charAt(j) == ',') continue;
				str += map.get(beNumbers[i].charAt(j));
			}
			result += Integer.parseInt(str);
		}
		
		return result;
	}
}
