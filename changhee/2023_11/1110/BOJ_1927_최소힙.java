import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
//Silver_1927.java

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException   {
        // Scanner scan = new Scanner(System.in);
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());// 1~n

        int input;
        PriorityQueue<Integer> minQueue = new PriorityQueue<Integer>();
        for (int i = 0; i < n; i++) {
            input = Integer.parseInt(br.readLine());
            if (input>0) {
                minQueue.add(input);
            } else {
                if (!minQueue.isEmpty()) {
                    System.out.println(minQueue.poll());
                }
                else{
                    System.out.println(0);
                }
            }
        }
        br.close();
    }
}
