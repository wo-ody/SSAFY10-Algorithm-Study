import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1331_나이트_투어 {
	static boolean [][]visited = new boolean[6][6];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
//		String start = br.readLine();
		
//		for(int i = 0 ; i < )
		
		String [] knight = new String[36];
		
		for(int i = 0 ; i < 36 ; i ++) {
			knight[i] = br.readLine();
			
			
		}
		
		boolean valid = true;
		for(int i = 1 ; i < 36 ; i ++) {
			if (!check(knight[i-1],knight[i])) {
				valid = false;
				break;
			}	
		}
		
		if (!check(knight[35],knight[0])) {
			valid = false;
//			break;
		}
		
		
		if (valid) {
			
			System.out.println("Valid");
		}
		else {
			System.out.println("Invalid");
		}
//		for(int i = 0 ; i  < 6; i ++) {
//			System.out.println(Arrays.toString(visited[i]));
//		}
	}
	static boolean check(String k1,String k2) {
		
		int x1=-1;
		int x2=-1;
		int y1=-1;
		int y2=-1;
		
		x1 = k1.charAt(0)-65;
//		System.out.println(x1);
		y1 = Integer.parseInt(Character.toString(k1.charAt(1)))-1;
		x2 = k2.charAt(0)-65;
		y2 = Integer.parseInt(Character.toString(k2.charAt(1)))-1;
		
		if (visited[x2][y2] == true) {
//			System.out.println(x2+" "+y2);
			return false;
		}
		visited[x2][y2] = true;
		
		int diff1 = Math.abs(x1-x2);
		int diff2 = Math.abs(y1-y2);
		
		if ((diff1 == 1 && diff2 == 2)||(diff1 ==2 && diff2 == 1)) {
			return true;
		}
		else {
			return false;
		}
		
	}
}
