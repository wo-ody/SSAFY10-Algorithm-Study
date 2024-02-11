package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class BOJ_2608_로마_숫자 {
    static String[] arabiaNumber = {"I", "IV", "V", "IX", "X", "XL","L", "XC", "C", "CD", "D", "CM", "M"};
    static int[] numberValue = {1,4,5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
    static TreeMap<String, Integer> map = new TreeMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < 13; i++) map.put(arabiaNumber[i], numberValue[i]);

        String first = br.readLine();
        String second = br.readLine();
        int sum = arabiaToNumber(first) + arabiaToNumber(second);
        String str = numberToArabia(sum);
/*
DLIII
MCMXL
*/
        System.out.println(sum);
        System.out.println(str);

    }
    static int arabiaToNumber(String str){
        int result = 0;
        for(int i = str.length()-1; i > 0; i--){
            String current = String.valueOf(str.charAt(i));
            String next = String.valueOf(str.charAt(i-1));
            int currentValue =  map.get(current);
            int nextValue = map.get(next);
            if(currentValue <= nextValue) result += currentValue;
            else {
                if(i == 1){
                    result += currentValue - nextValue;
                    return result;
                }
                result += currentValue - nextValue;
                i--;
            }
        }

        result += map.get(String.valueOf(str.charAt(0)));
        return result;
    }
    static String numberToArabia(int sum){
        StringBuilder sb = new StringBuilder();
        String convert = String.valueOf(sum);
        for(int i = convert.length()-1; i > 0; i--){
            for(int j = 12; j >= 0; j--){
                int highValue = numberValue[j];
                String highText = arabiaNumber[j];
                int div = sum/highValue;
                sum %= highValue;

                sb.append(String.valueOf(highText).repeat(div));
            }

        }
        return sb.toString();
    }

}
