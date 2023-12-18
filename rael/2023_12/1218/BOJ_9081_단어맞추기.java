import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb =new StringBuilder();
				
		int T = sc.nextInt();
		sc.nextLine();
		for (int t = 1; t <= T; t++) {
			char[] str = sc.nextLine().toCharArray();
			sb.append(String.valueOf(np(str))).append('\n');
		}
		System.out.println(sb);
	}
	static char[] np(char[] str) { 
		for (int i = str.length-1; i >= 1; i--) {
			if(str[i]>str[i-1]) {
				for (int j = str.length-1; j >= 1; j--) { 
					if(str[j]>str[i-1]) { 
						char temp = str[i-1];
						str[i-1] = str[j];
						str[j] = temp; 
						
						str = swapLast(str, i);
						return str;
					}
				}
			}
		}
		return str;
	}
	static char[] swapLast(char[] str, int i) {
		int lastIdx = str.length-1;
		for (int j = i; j <= (i+str.length-1)/2; j++) {
			char temp = str[j];
			str[j] = str[lastIdx];
			str[lastIdx--] = temp;
		}
		return str;
	}
}
