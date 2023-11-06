import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		char[] word = input.toCharArray();
		int num = input.length();
		boolean check = true;
		
		for(int i=0; i<num/2; i++) {
			if(word[i] != word[num-i-1]) {
				check = false;
				break;
			}
		}
		
		if(check) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}
		
		sc.close();
  }
}
