package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_20310_타노스 {
    static char[] map;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = br.readLine().toCharArray();

        int zero = 0;
        int one = 0;
        for (int i = 0; i < map.length; i++) {
            if(map[i] == '0') zero++;
            else one++;
        }

        // 0은 뒤에서부터 제거
        // 1은 앞에서부터 제거
        int left = 0;
        int right = map.length - 1;
        zero /= 2;
        one /= 2;
        while(left != -1 || right != -1){
            if(left != -1 && map[left] == '1'){
                one--;
                map[left] = '.';
            }
            if(right != -1 && map[right] == '0'){
                zero--;
                map[right] = '.';
            }

            left++;
            right--;

            if(one == 0) left = -1;
            if(zero == 0) right = -1;


        }


        for (int i = 0; i < map.length; i++) {
            if(map[i] == '.') continue;
            System.out.print(map[i]);
        }
    }

    static void erase(char c, int cnt){

        for (int i = 0; i < map.length; i++) {
            if(map[i] == c){
                cnt--;
                map[i] = '.';
            }

            if(cnt == 0) break;
        }
    }

}
