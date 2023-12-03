package practice.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2179 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int n;
	static String[] words;
	static String s = null, t = null;
	
    public static void main(String[] args) throws IOException {
    	n = Integer.parseInt(br.readLine());
    	words = new String[n];
    	for(int i = 0; i < n; i++)
    		words[i] = br.readLine(); 
    	int max_len = Integer.MIN_VALUE;
    	int len;

    	for(int i = 0; i < n-1; i++) {
    		for(int j = i + 1; j < n; j++) {
    			len = 0;
    			for(int k = 0; k < Math.min(words[i].length(), words[j].length()); k++) {
	    			if(words[i].charAt(k) == words[j].charAt(k))
	    				len++;
	    			else  // 같지 않다면 더 이상 확인할 필요 없음
	    				break;
    			}
        		if(max_len < len) {  // 구한 길이가 지금 갱신되어 있는 길이보다 길다면
        			max_len = len;
        			s = words[i];
    	    		t = words[j];
        		}
    		}
    	}
    	System.out.println(s);
    	System.out.println(t);
    }  
}
