import java.util.*;
public class BOJ_1032_명령_프롬프트 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		String[] array = new String[N];
		for(int i=0;i<N;i++) {
			array[i] = sc.next();
		}
		
		StringBuilder sb = new StringBuilder();
		boolean isSame=true;
		for(int i=0;i<array[0].length();i++) {
			char c = array[0].charAt(i);
			
			isSame=true;
			for(int j=1;j<N;j++) {
				if(c!=array[j].charAt(i)) {
					isSame=false;
					break;
				}
			}
			
			if(isSame==true) {
				sb.append(c);
			} else
				sb.append('?');
		}
		System.out.println(sb.toString());
	}

}
