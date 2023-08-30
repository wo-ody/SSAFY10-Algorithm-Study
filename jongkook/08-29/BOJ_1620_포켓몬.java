package boj;

import java.util.*;
import java.io.*;

public class BOJ_1620_포켓몬 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int pokeQuantity = Integer.parseInt(st.nextToken());
		int QuestionQuantity = Integer.parseInt(st.nextToken());
		Map<Integer, String> pokemon = new HashMap<Integer, String>();
		Map<String, Integer > pokemon2 = new HashMap<String, Integer>();
		
		for(int p = 1; p <= pokeQuantity; p++) {
			String str = br.readLine();
			pokemon.put(p, str);		
			pokemon2.put( str, p);		
		}
		for(int q = 0; q < QuestionQuantity; q++) {
			String str = br.readLine();
			// 문자열을 찾아야 하기 때문에
			// pokemon로 찾는다.
			if(digitCheck(str)) {
				System.out.println( pokemon.get(Integer.parseInt(str)));
			}
			// 문자열을 찾아야 하기 때문에
			// pokemon로 찾는다.
			else {
				System.out.println(pokemon2.get(str));
			}
			
		}
	}
	
	// true 반환 시 이것은 숫자이다.
	static boolean digitCheck(String str) {
		try {
			int s = Integer.parseInt(str);
		}
		catch(NumberFormatException e){
			return false;
		}
		return true;
	}
}
