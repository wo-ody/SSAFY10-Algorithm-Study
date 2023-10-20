import java.util.*;

class Solution {
    static HashMap<String, String> map = new HashMap<>(); // 아이디별 최종 닉네임 저장
    static List<String> list = new ArrayList<>(); // 아이디별로 입장인지 퇴장인지에 따라 저장 0uid~~, 1uid, 2uid~
    static List<String> ans = new ArrayList<>();
    
    public List<String> solution(String[] record) {
        for (String r : record) {
            // System.out.println(r);
            String[] user = r.split(" ");
            if (user[0].equals("Enter")) {
                // 입장시에는 닉네임 변경해주고 list에 E + "닉네임"으로 추가
                map.put(user[1], user[2]);
                list.add("E" + user[1]);
            } else if (user[0].equals("Change")) {
                // 닉네임 변경은 list에 담지 않고 map에만 덮어쓰기 
                map.put(user[1], user[2]);
            } else {
                list.add("L" + user[1]);
            }
        }
        // 맨 앞에 글자를 잘라서 E , L인지 구별하고 닉네임은 map에서 가져와서 result에 추가
        for (String s : list) {
            StringBuilder sb = new StringBuilder();
            // System.out.println(s);
            String ac = s.substring(0, 1);
            String name = s.substring(1, s.length());
            String nickName = map.get(name);
            System.out.println(ac);
            sb.append(nickName).append("님이 ");
            switch (ac) {
                case "E":
                    sb.append("들어왔습니다.");
                    ans.add(sb.toString());
                    break;
                case "L":
                    sb.append("나갔습니다.");
                    ans.add(sb.toString());
                    break;
            }
            
        }
        return ans;
    }
}
