package BOJ;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public  class BOJ_1105_팔 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        Integer L = Integer.parseInt(st.nextToken());
        Integer R = Integer.parseInt(st.nextToken());

        // 같은 자리수인 경우 :  앞에서부터 확인하면서 얼마나 같은지 ? 를 확인한다
        // 같지 않는 곳이 나온다면 ( 88788, 88888 ) 그 수부터는 무조건 ? 8이 아닐 수 있나
        // ( 88799, 88888 ) 인 경우에는 어떡하지
        // ( 88888, 88900 )
        // 두 수가 다르다: 둘 중 하나는 8이 아니다.
        // 두 수가 같다 : 두 수 모두 8이 아니면 된다

        // 다른 자릿수인 경우 : 무조건 100000.. 이 존재하기 때문에 0

        if (L.toString().length() != R.toString().length())
            System.out.println(0);
        else{
            int len = L.toString().length();
            int cnt_8 = 0;
            int index = 0;

            char [] arr_L = L.toString().toCharArray();
            char [] arr_R = R.toString().toCharArray();
            for(int i = 0;i <len ; i++){
                if (arr_L[i] != arr_R[i])
                    break;

                if (arr_L[i] == '8'){
                    cnt_8 ++;
                }
            }
            System.out.println(cnt_8);
        }

    }
}