import java.util.ArrayDeque;
import java.util.Scanner;

public class BOJ_2164_카드2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for(int i = 1; i<=n; i++){
            deque.addLast(i);
        }
        while(deque.size() != 1){
            deque.removeFirst();
            int top = deque.removeFirst();
            deque.addLast(top);
        }
        System.out.println(deque.getFirst());
    }
}
