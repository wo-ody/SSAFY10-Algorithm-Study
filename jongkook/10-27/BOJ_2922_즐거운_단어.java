package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BOJ_2922_즐거운_단어 {
    static int blankCnt;
    static String vowel = "AEIOU";
    static long ans = 0;
    static char[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = br.readLine().toCharArray();
        blankCnt = 0;
        for(int i=0; i<arr.length; i++) if(arr[i] == '_') blankCnt++;

        findBlank(0,0);
        System.out.println(ans);
    }

    private static void findBlank(int idx, int cnt) {
        if(cnt>=blankCnt) {
            calculate();
            return;
        }

        for(int i=idx; i<arr.length; i++) {
            if(arr[i] == '_') {
                // 자음
                arr[i] = '1';
                findBlank(i+1, cnt+1);
                // 모음
                arr[i] = '2';
                findBlank(i+1, cnt+1);
                arr[i] = 'L';
                findBlank(i+1, cnt+1);
                arr[i] = '_';
            }
        }
    }

    private static void calculate() {
        int check = checkThreeTimes();
        if(check == 0) {
            long total = 1;
            for(int i=0; i<arr.length; i++) total *= arr[i] == '1' ? 20 : arr[i] == '2' ? 5 : 1;
            ans+=total;
        }
    }


    private static int checkThreeTimes () {
        int st = 0;
        int ed = 2;
        // L값 체크
        boolean isL = false;
        while(ed<arr.length) {
            // 모음 갯수
            int v = 0;
            // 자음 갯수
            int c = 0;
            for(int i=st; i<=ed; i++) {
                if(arr[i] == 'L') isL = true;
                if(vowel.indexOf(arr[i])>=0 || arr[i] == '2') v++;
                else c++;
            }

            // 모음 3개로 인한 반환
            if(v >=3) return 1;
                // 자음 3개로 인한 반환
            else if(c>=3) return 2;
            st++;
            ed++;
        }
        // L값이 존재하며 자음 모음에 연속성 없음
        if(isL) return 0;

        return -1;
    }
}
