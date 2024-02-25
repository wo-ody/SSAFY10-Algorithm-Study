import java.io.*;
 
public class Main {
	public static void main(String[] args) throws IOException {
    
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		int len = str.length();
		int count = 0;
 
		for (int i = 0; i < len; i++) {
 
			char ch = str.charAt(i);
 
			if(ch == 'c' && i < len - 1) {			// 만약 ch 가 c 라면?
				//만약 ch 다음 문자가 '=' 또는 '-' 이라면?
				if(str.charAt(i + 1) == '=' || str.charAt(i + 1) == '-') {		
					// i+1 까지가 하나의 문자이므로 다음 문자를 건너 뛰기 위해 1 증가
					i++;		
				}
				
			}
		    
			else if(ch == 'd' && i < len - 1) {
				if(str.charAt(i + 1) == '-') {	// d- 일 경우
						i++;
					}
				else if(str.charAt(i + 1) == 'z' && i < len - 2) {
					
					if(str.charAt(i + 2) == '=') {	// dz= 일 경우
						i += 2;
					}
				}
			}
		    
			else if((ch == 'l' || ch == 'n') && i < len - 1) {
				if(str.charAt(i + 1) == 'j') {	// lj 또는 nj 일 경우
					i++;
				}
			}
		    
 
			else if((ch == 's' || ch == 'z') && i < len - 1) {
				if(str.charAt(i + 1) == '=') {	// s= 또는z= 일 경우
					i++;
				}
			
		    }
		    
			count++;
 
		}
 
		System.out.println(count);
	}
}
