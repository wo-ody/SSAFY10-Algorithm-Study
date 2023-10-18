import java.io.*;
import java.util.*;

public class Main {
    static String S,T;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = br.readLine();
        T = br.readLine();

        System.out.println(simulation());
    }

    static int simulation(){

        Queue<String> q = new ArrayDeque<>();
        q.add(T);

        while(!q.isEmpty()){
            String cur = q.poll();
            if(cur.equals(S)) return 1;
            int size = cur.length();

            // 존재할 수 없음
            if(cur.charAt(0) == 'A' && cur.charAt(size-1)=='B') continue;
            
            // S > T 이면 끝
            if(S.length() > cur.length()) break;

            if(cur.charAt(0) == cur.charAt(size - 1) && cur.charAt(0) == 'A')
                q.add(cur.substring(0,size-1));
            else if(cur.charAt(0) == cur.charAt(size - 1) && cur.charAt(0) == 'B') {
                String tmp = "";
                for (int i = size - 1; i >= 0; i--) {
                    tmp += cur.charAt(i);
                }
                int l = tmp.length();
                q.add(tmp.substring(0,l - 1));
            }
            else{
                // 뒤집고 빼기
                String tmp = "";
                for (int i = size - 1; i >= 0; i--) {
                    tmp += cur.charAt(i);
                }
                int l = tmp.length();
                q.add(tmp.substring(0,l - 1));
                // 그냥 뒤에것 빼기
                q.add(cur.substring(0,size-1));
            }


        }

        return 0;
    }
}
