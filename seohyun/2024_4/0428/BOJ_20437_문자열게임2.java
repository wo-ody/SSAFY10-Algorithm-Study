import java.io.*;
import java.util.*;
public class Main {
    static ArrayList<Integer>[] hmap;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            String s = br.readLine();
            int K = Integer.parseInt(br.readLine());

            simulation(s,K);

        }

        System.out.println(sb);
    }

    static void simulation(String input, int K){
        int minR = input.length() + 10;
        int maxR = -1;
        boolean isChange = false;

        hmap = new ArrayList[30];
        for (int i = 0; i < 30; i++) {
            hmap[i] = new ArrayList<>();
        }

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            hmap[c - 'a'].add(i);

            if(hmap[c - 'a'].size() >= K){
                int last_idx = hmap[c - 'a'].size() - 1;
                int last = hmap[c-'a'].get(last_idx);
                int first = hmap[c-'a'].get(last_idx - K + 1);
                minR = Math.min(minR, last - first);
                maxR = Math.max(maxR, last - first);
                isChange = true;
            }
        }

        if(isChange) sb.append(minR + 1).append(" ").append(maxR + 1).append("\n");
        else sb.append(-1).append("\n");
    }

    static class Node{
        ArrayList<Integer> arr = new ArrayList<>();
        int num = 0;
        Node(ArrayList<Integer> arr, int num){
            this.arr = arr;
            this.num = num;
        }
    }
}
