public class 스킬트리 {
    public static void main(String[] args) {
        System.out.println(solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"}));
    }
 
    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;
 
        for(int i = 0; i < skill_trees.length; i++) {
            // 정규식으로 선행 스킬들만 남은 문자열 생성
            String skillOrder = skill_trees[i].replaceAll("[^" + skill + "]", "");
            String requiredSkillOrder = skill.substring(0, skillOrder.length());
 
            if(skillOrder.equals(requiredSkillOrder)) {
                answer++;
            }
        }
        return answer;
    }
}
