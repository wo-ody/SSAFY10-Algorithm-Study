class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for (int i = 0; i < skill_trees.length; i++) {
			String stree = skill_trees[i].replaceAll("[^" + skill + "]", ""); // skill문자를 제외한 문자 치환
			for (int j = 0; j < skill.length() + 1; j++) {
				String sub_skill = skill.substring(0, j); // skill을 한 글자씩 잘라
				if (stree.equals(sub_skill)) { // 가능한 스킬트리인지 확인
					answer++;
					break;
				}
			}
        }
        
        return answer;
    }
}
