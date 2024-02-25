package algorithm2024.feb.day25;

import javax.sound.midi.Soundbank;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_8979_올림픽 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static class Country{
        int c, g,s,b, rank;

        public Country(int c, int g, int s, int b) {
            this.c = c;
            this.g = g;
            this.s = s;
            this.b = b;
        }

        @Override
        public String toString() {
            return "Country{" +
                    "c=" + c +
                    ", g=" + g +
                    ", s=" + s +
                    ", b=" + b +
                    ", rank=" + rank +
                    '}';
        }
    }
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        List<Country> countryList = new ArrayList<>();
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            countryList.add(new Country(c,g,s,b));
        }
        countryList.sort((o1,o2)->{
            if(o1.g==o2.g){
                if(o1.s==o2.s){
                    return o2.b-o1.b;
                }else{
                    return o2.s-o1.s;
                }
            }else{
                return o2.g-o1.g;
            }
        });
        int cnt = 1;
        countryList.get(0).rank = 1;
        if(countryList.get(0).c==K){
            System.out.println(1);
            return;
        }
        for (int i = 1; i < countryList.size(); i++) {
            Country prev = countryList.get(i-1);
            Country cur = countryList.get(i);
            if(prev.g==cur.g&&prev.s==cur.s&&prev.b==cur.b){
                cur.rank = prev.rank;
                cnt++;
            }else{
                cur.rank = prev.rank+cnt;
                cnt = 1;
            }
            if (cur.c == K) {
                System.out.println(cur.rank);
                break;
            }
        }

    }
}
