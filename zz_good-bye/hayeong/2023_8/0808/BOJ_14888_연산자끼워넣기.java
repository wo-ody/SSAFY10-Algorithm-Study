import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 연산자끼워넣기_14888 {
    static int N;
    static int[] num;
    static char[] operator;

    static boolean[] selected;

    static char[] target;

    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    static Deque<Integer> numQueue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        // 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        num = new int[N];
        operator = new char[N - 1];
        selected = new boolean[N - 1];
        target = new char[N - 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        // 연산자 배열로 변경
        int idx = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            char op = getOperator(i);
            for (int j = 0; j < tmp; j++) {
                operator[idx] = op;
                idx++;
            }
        }

        // 모든 연산자 순열별로 식을 계산
        perm(0);
        System.out.println(max);
        System.out.println(min);


    }

    // 순열
    public static void perm(int tgtIdx) {
        if (tgtIdx == N - 1) {
            // complete code
            // 현재 연산자 순서로 식 계산
            int tmp = calculate(target);
            min = Math.min(min, tmp); // 최소
            max = Math.max(max, tmp); // 최대
            return;
        }

        for (int i = 0; i < N - 1; i++) {
            if (selected[i]) continue;
            target[tgtIdx] = operator[i];
            selected[i] = true;
            perm(tgtIdx + 1);
            selected[i] = false;
        }
    }

    public static int calculate(char[] ops) {
        // 연산자 큐
        Deque<Character> opQueue = new ArrayDeque<>();
        for (int i = 0; i <N-1; i++) {
            opQueue.offer(ops[i]);
        }

        // 숫자 큐
        for (int i = 0; i <N; i++) {
            numQueue.offer(num[i]);
        }

        // 삭 계산
        while (numQueue.size() != 1) {
            int n1 = numQueue.poll();
            int n2 = numQueue.poll();
            int op = opQueue.poll();
            int tmp = 0;
            if (op == '+') tmp = n1 + n2;
            else if (op == '-') tmp = n1 - n2;
            else if (op == '*') tmp = n1 * n2;
            else if(op == '/')tmp = n1 / n2;
            numQueue.addFirst(tmp);
        }
        return numQueue.poll();
    }

    // + - * / 순으로 입력받은 연산자 개수를 실제 연산자로 변환
    public static char getOperator(int i) {
        char op = ' ';
        switch (i) {
            case 0:
                op = '+';
                break;
            case 1:
                op = '-';
                break;
            case 2:
                op = '*';
                break;
            case 3:
                op = '/';
                break;
        }
        return op;
    }
}
