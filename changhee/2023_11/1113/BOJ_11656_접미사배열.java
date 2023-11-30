import java.io.*;
import java.util.*;
 
public class Main {
 
    public static void main(String[] args) throws IOException {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 
        String s = br.readLine();
 
        String[] strArray = new String[s.length()];
        // 입력 string 크기만큼 배열 생성
        for (int i = 0; i < s.length(); i++) {
            strArray[i] = s.substring(i,s.length());
        }
        // 하나씩 잘라서 넣고
        Arrays.sort(strArray);
        // 알파벳순 정렬
        for(String str : strArray) {
            bw.write(str);
            bw.write('\n');
        }
        
        bw.flush();
 
    }
 
}
