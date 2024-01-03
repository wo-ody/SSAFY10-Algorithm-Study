package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1124_언더프라임 {
    static boolean [] prime_arr;
    static ArrayList<Integer> prime_num;
    public static void main(String[] args) throws IOException {
        // 당연하게도 에라토스테네스의 체를 사용해야한다.
        // 하지만 반복되는 계산들이 많다.
        // 얘네를 해결하기 위해서 dp를 사용할것

        prime_arr = new boolean[100_001];
        prime_num = new ArrayList<>();
        make_prime_arr();
//        System.out.println(prime_num.size());

        int [] dp = new int [100_001];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A =  Integer.parseInt(st.nextToken());
        int B =  Integer.parseInt(st.nextToken());

        int answer = 0;
        for(int i = A ; i <= B ; i ++){

            int num = i;
            int cnt = 0;

            for (int div : prime_num){
                if (div > num)
                    break;
                while (num % div == 0){
                    cnt += 1;
                    num /= div;
                }
//                if ( num % div == 0){
//                    while (num )
//                    cnt += num/ div;
//                    num /= div;
//                }
            }

            if (prime_arr[cnt])
                answer += 1;
        }

        System.out.println(answer);


//        for(int i = 2; i <100_001 ; i ++){
//            if (prime_arr[i])
//                dp[i] = 1;
//        }

//        bottom_top(dp);
//        System.out.println(Arrays.toString(dp));

        // 소수면 1 아니면 소인수 분해 진행 => 결과값을 dp 에 저장
    }

    static void bottom_top(int [] dp){

        for(int i = 2 ; i < 50_001; i ++){
            int idx = 0;

            while (prime_num.get(idx) * i <100_001 ){
                if (i == prime_num.get(idx))
                    dp[prime_num.get(idx) * i] += dp[i];
                dp[prime_num.get(idx) * i] += dp[i];
                idx++;
            }
        }
    }
    static int cnt_primes(int num, int [] dp){
        if (prime_arr[num])
            return 1; // 소인수 분해의 결과 소수가 자기 자신밖에 없음

        if (dp[num] != 0)
            return dp[num];

        ArrayList<Integer> primes = divide_primes(num);
        // 안의 갯수를 dp에 저장하고 리턴

        return dp[num] = primes.size();

    }
    static ArrayList<Integer> divide_primes(int num){

        ArrayList<Integer> result = new ArrayList<>();
        if (prime_arr[num]) {
            result.add(num);
            return result;
        }
        int div_num = 1;

        while(div_num <= num){
            div_num ++;
            if (!prime_arr[div_num])
                continue;
            if (num % div_num == 0){
                while(num % div_num == 0){
                    result.add(div_num);
                    num /= div_num;
                }
            }
        }
        return result;
    }

    static void make_prime_arr(){

        for(int i = 2 ; i < prime_arr.length; i ++){
            prime_arr[i] = true;
        }
        for(int i = 2; i < prime_arr.length; i ++){
            if (!prime_arr[i])
                continue;

            prime_num.add(i);
            for (int j = i * 2 ; j < prime_arr.length; j += i ){
                prime_arr[j] = false;
            }
        }
    }
}
