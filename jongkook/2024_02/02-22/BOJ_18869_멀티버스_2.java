package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_18869_멀티버스_2 {
    static int universeSize, planetSize, result;
    static ArrayList<ArrayList<Integer>> lst = new ArrayList<>();
    static int[][] array;
    static int[] comb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        universeSize = Integer.parseInt(st.nextToken());
        planetSize = Integer.parseInt(st.nextToken());
        array = new int[universeSize][planetSize];
        comb = new int[2];

        for(int i = 0; i <= universeSize; i++) lst.add(new ArrayList<>());

        for(int u = 0; u < universeSize; u++){
            st = new StringTokenizer(br.readLine());
            TreeSet<Integer> set = new TreeSet<>();
            for(int p = 0; p < planetSize; p++){
                int value = Integer.parseInt(st.nextToken());
                array[u][p] = value;
                set.add(value);
            }
            for(Integer i : set) lst.get(u).add(i);
        }

        for(int u = 0; u < universeSize; u++){
            for(int p = 0; p < planetSize; p++){
                array[u][p] = Collections.binarySearch(lst.get(u), array[u][p]);
            }
        }


        isEqauls(0, 0);

        System.out.println(result);
    }
    static void isEqauls(int start, int count){
        if(count == 2){
            int one = comb[0];
            int two = comb[1];
            if(Arrays.equals(array[one], array[two])) result++;

            return;
        }
        for(int i = start; i < universeSize; i++){
            comb[count] = i;
            isEqauls(i+1, count+1);
        }
    }
}
