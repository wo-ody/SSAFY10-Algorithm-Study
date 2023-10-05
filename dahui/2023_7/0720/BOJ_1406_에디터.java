package BOJ;

import java.io.*;
import java.util.*;

public class Boj_1406 {

	public static void main(String[] args) throws IOException {
		//문자열의 수를 모르는채로 입력 받아야 해서 bufferedReader 사용 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		int M = Integer.parseInt(br.readLine());
		
		LinkedList<Character> list = new LinkedList<Character>();

		for(int i=0; i<str.length(); i++) {
			list.add(str.charAt(i));
		}
		
		//커서 위치 
		ListIterator<Character> iter = list.listIterator();
		//맨뒤로 
		while(iter.hasNext()) {
			iter.next();
		}
		
		for(int i=0; i<M; i++) {
			String com = br.readLine();
			char c = com.charAt(0);
			
			if(c == 'L') {
				if(iter.hasPrevious()) {
					iter.previous();
				}
			} else if(c == 'D') {
				if(iter.hasNext()) {
					iter.next();
				}
			} else if(c == 'B') {
				if(iter.hasPrevious()) {
					iter.previous();
					iter.remove();
				}
			} else {
				char text = com.charAt(2);
				iter.add(text);
			}
		}
		
		for(Character chr : list) {
			bw.write(chr);
		}
		//list.get(i)의 시간복잡도 문제 -> for-each 루프를 사용하면 리스트 크기에 상관없이 내부적으로 반복자를 사용하여 요소에 접근
		//for문을 사용하면 매번 list.get(i)를 호출해야해서 리스트 크기 n만큼 메소드 호출이 발생 -> 시간복잡도가 n -> n^2가 
        
		bw.flush();
		bw.close();

	}

}
