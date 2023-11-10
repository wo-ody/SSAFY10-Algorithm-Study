package Algorithm_2023.src.month11.day10;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_4659_비밀번호발음하기 {

    static String str;
    static boolean isConsonants, isTriple, isSameChar;
    static int cntConsonants, cntVowels;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while( !(str = br.readLine()).equals("end") ) {
            char[] input = str.toCharArray();

            // 조건
            // 1. 모음 1개 포함( 없으면 불가능 ) a e i o u
            // 2. 연속3모음, 연속3자음 안됨 => 자음 모음 연속 카운트
            // 3. ee oo를 제외한 똑같은 문자 불가능

            // 초기화
            isConsonants = isTriple = isSameChar = false;
            cntConsonants = cntVowels = 0;
            char prev = 0;

            for (char c : input) {
                // 1. 모음 1개 포함( 없으면 불가능 ) a e i o u
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    isConsonants = true;
                    cntVowels = 0;
                    cntConsonants++;
                } else {
                    cntVowels++;
                    cntConsonants = 0;
                }
                // 2. 연속3모음, 연속3자음 안됨 => 자음 모음 연속 카운트
                if (cntConsonants == 3 || cntVowels == 3) isTriple = true;

                // 3. ee oo를 제외한 똑같은 문자 불가능
                if (prev == c && c != 'e' && c != 'o') isSameChar = true;
                prev = c;
            }
            sb.append("<").append(str).append("> ").append("is ")
                    .append(isConsonants && !isTriple && !isSameChar ? "": "not ")
                    .append("acceptable.\n");
        }
        System.out.print(sb);
    }

}
