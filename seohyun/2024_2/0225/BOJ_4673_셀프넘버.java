package boj;

public class boj_4673_셀프넘버 {
    public static void main(String[] args) throws Exception{

        StringBuilder sb = new StringBuilder();

        boolean[] num = new boolean[10010];

        // false 면 sb 에 담기

        for (int i = 1; i <= 10000 ; i++) {
            if(!num[i]) sb.append(i).append("\n");

            int su = i;
            int remainder;
            int sum = i;
            while(su != 0){
                remainder = su % 10;
                sum += remainder;
                su /= 10;
            }

            if(sum <= 10000) num[sum] = true;
        }

        System.out.println(sb);
    }
}
