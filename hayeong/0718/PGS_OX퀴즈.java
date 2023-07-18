public class OX퀴즈 {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];

        for (int i = 0; i < quiz.length; i++) {
            String[] ops = quiz[i].split(" ");

            if (ops[1].equals("-")) {
                if (Integer.parseInt(ops[0]) - Integer.parseInt(ops[2]) == Integer.parseInt(ops[4])) {
                    answer[i] = "O";

                } else {
                    answer[i] = "X";
                }
            } else if (ops[1].equals("+")) {
                if (Integer.parseInt(ops[0]) + Integer.parseInt(ops[2]) == Integer.parseInt(ops[4])) {
                    answer[i] = "O";

                } else {
                    answer[i] = "X";
                }
            }
        }
        return answer;
    }
}
