import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str = br.readLine().toCharArray();
        char[] pattern = br.readLine().toCharArray();
        
        int sLen = str.length;
        int pLen = pattern.length;
        
        int[] table = new int[pLen];
        
       
        int j = 0;
        for(int i =1; i<pLen; i++) {
        	while(j>0 && pattern[i] != pattern[j]) j=table[j-1];
        	if(pattern[i] == pattern[j]) table[i] = ++j;
        }
        
        int count = 0;
        List<Integer> point = new ArrayList<>();
        
        j=0;
        for(int i=0; i<sLen; i++) {
        	while(j>0 && str[i] != pattern[j]) j=table[j-1];
        	
        	if(str[i] == pattern[j]) {
        		if(j==pattern.length-1) {
        			count++;
        			point.add(i-pattern.length+2);
        			j=table[j];
        		}else {
        			j++;
        		}
        	}
        }
        
        StringBuilder answer = new StringBuilder();
        answer.append(count).append("\n");
        for(int i : point) answer.append(i).append(" ");
        System.out.println(answer);
    }
}
