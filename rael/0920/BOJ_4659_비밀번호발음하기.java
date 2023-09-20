import java.util.*;
import java.io.*;

public class BOJ_4659_비밀번호발음하기 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        char[] vowels = { 'a', 'e', 'i', 'o', 'u'}; //모음

        while(true){
            st = new StringTokenizer(br.readLine());
            String input = st.nextToken();
            if(input.equals("end")) break;
            else {
                boolean acceptable = true;
                boolean hasVowel = false;
                int cntVowel = 0;//모음 카운트
                int cntConsonant = 0;//자음 카운트
                for(int i = 0; i < input.length(); i++){
                    char cur = input.charAt(i);
                    boolean isVoewl = false;
                    //모음인지 확인 : 모음이 연속 몇 번 나오는지 체크, 자음 연속 개수는 0으로
                    for(int j = 0; j < vowels.length; j++){
                        if(cur == vowels[j]){
                            isVoewl = true;
                            hasVowel = true;
                            cntVowel++;
                            cntConsonant = 0;
                            break;
                        }
                    }
                    //자음이라면
                    if(!isVoewl) {
                        cntConsonant++;
                        cntVowel = 0;
                    }
                    //문자열 끝까지 탐색했는데 모음이 없다면
                    if(i == input.length()-1){
                        if(!hasVowel) {
                            System.out.println("<" + input + "> is not acceptable.");
                            acceptable = false;
                            break;
                        }
                    }
                    if(i >= 1){
                        //동일한 문자가 2개 연속되는지 검사
                        if(cur == input.charAt(i-1) && cur != 'e' && cur != 'o'){
                            System.out.println("<" + input + "> is not acceptable.");
                            acceptable = false;
                            break;
                        }
                        //모음 혹은 자음이 3개 연속되는지 검사
                        else if(cntVowel >= 3 || cntConsonant >= 3){
                            System.out.println("<" + input + "> is not acceptable.");
                            acceptable = false;
                            break;
                        }
                    }
                }
                if(acceptable) System.out.println("<" + input + "> is acceptable.");
            }
        }
    }
}