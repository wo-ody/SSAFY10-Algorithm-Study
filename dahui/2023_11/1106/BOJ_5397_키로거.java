package alone;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
// 대문자, 소문자, 숫자 , 백스페이스(-), 화살표 (<, >)
//백스페이스 커서 앞 글자 지우기 ( 있다면 )
//화살표 ( 커서 옮기기 , list 인덱스보다 커지거나 0보다 작아지지 않게 하기 )
public class BOJ_5397_키로거 {
	static String str, ans;
	static int T;
	static LinkedList<Character> list = new LinkedList<>();
	static StringBuilder sb = new StringBuilder();
	static StringBuilder sb2 = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			str = br.readLine();
			int index = 0;
			list = new LinkedList<>();
			sb2.setLength(0);
			
			for(int i=0; i<str.length(); i++) {
				char c = str.charAt(i);
				if(c == '-') {
					if(index != 0) {
						list.remove(index-1);
						index--;
					}
				}else if(c == '<') {
					if(index != 0) {
						index--;
					}
				}else if(c == '>') {
					if(index != list.size()) {
						index++;
					}
				}else {
					list.add(index, c);
					index++;
				}
			}
			
			for (Character c : list) {
				sb2.append(c);
			}
			
			sb.append(sb2).append("\n");
		}
		System.out.println(sb);
		
	}

}
