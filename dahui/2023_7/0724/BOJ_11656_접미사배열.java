import java.io.*;
import java.util.*;
 
public class Main {
 
    public static void main(String[] args) throws IOException {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 
        String s = br.readLine();
 
        String[] arr = new String[s.length()];
        for (int i = 0; i < s.length(); i++) {
            arr[i] = s.substring(i,s.length()); //하나씩 넣기
        }

        Arrays.sort(arr); //알파벳 순 정렬

        for(String str : arr) {
            bw.write(str);
            bw.write('\n');
        }
        
        bw.flush();
 
    }
 
}
