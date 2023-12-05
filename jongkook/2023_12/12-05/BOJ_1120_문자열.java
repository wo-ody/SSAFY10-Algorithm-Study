package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1120_문자열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String first = st.nextToken();
        String last = st.nextToken();
        System.out.println(compareString(first, last));

    }
    static int compareString(String a, String b){
        int cnt = 0;
        if(a.length() == b.length()){
            for(int l = 0; l < a.length(); l++){
                if(a.charAt(l) != b.charAt(l)) cnt++;
            }
            return cnt;
        }
        else{

            int min = Integer.MAX_VALUE;
            for(int d = 0; d < b.length() - a.length() + 1; d++){
                int myCnt = 0;
                for(int f =0; f < a.length(); f++){
                    if(a.charAt(f) != b.charAt(d+f)) myCnt++;
                }
                min = Math.min(min, myCnt);
            }
            return min;
        }

    }
}
