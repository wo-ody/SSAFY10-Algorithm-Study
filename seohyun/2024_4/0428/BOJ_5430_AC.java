import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            // 수행할 함수
            String cmd = br.readLine();

            // 배열에 들어있는 개수
            int n = Integer.parseInt(br.readLine());

            // 배열에 들어있는 정수
            String str = br.readLine();

            String[] strarr = str.substring(1,str.length()-1).split(",");

            ArrayDeque<Integer> deque = new ArrayDeque<>();
            for(String s : strarr){
                if (!s.equals("")) deque.offer(Integer.parseInt(s));
            }

            boolean start0 = true;
            boolean end = false;
            for (int i = 0; i < cmd.length(); i++) {
                if (cmd.charAt(i) == 'D'){
                    // 제일 앞에 문자 빼기
                    if (deque.isEmpty()) {
                        System.out.println("error");
                        end = true;
                        break;
                    }
                    else {
                        if (start0) {
                            // 제일 앞에서부터 보고 있으면
                            deque.poll();
                        }else{
                            deque.pollLast();
                        }

                    }
                }else{
                    start0 ^= true;
                }
            }

            if (!end){
                StringBuilder sb = new StringBuilder();

                sb.append("[");
                if (start0){
                    while(!deque.isEmpty()){
                        sb.append(deque.poll());
                        if (!deque.isEmpty()) sb.append(",");
                    }
                }else{
                    while(!deque.isEmpty()){
                        sb.append(deque.pollLast());
                        if (!deque.isEmpty()) sb.append(",");
                    }
                }
                sb.append("]");




                System.out.println(sb);
            }



        }


    }


}
