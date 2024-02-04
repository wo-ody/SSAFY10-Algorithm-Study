package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_12015_가장_긴_증가하는_부분_수열2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N];
        ArrayList<Integer> lst = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int n = 0; n < N; n++) array[n] = Integer.parseInt(st.nextToken());
        lst.add(0);
        for(int i = 0; i < N; i++){
            int num = array[i];
            if(num > lst.get(lst.size()-1)) lst.add(num);
            else search(num, lst);
        }
        System.out.println(lst.size()-1);
    }
    static void search(int num, ArrayList<Integer> lst){
        int start = 0;
        int end = lst.size()-1;
        int mid = 0;
        while(start < end){
            mid = (start + end)/2;
            if(lst.get(mid) < num) start = mid+1;
            else end = mid;
        }
        lst.set(end, num);
    }
}
