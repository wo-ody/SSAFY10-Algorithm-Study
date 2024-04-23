def solution(friends, gifts):
    network = {i: {j: 0 for j in friends} for i in friends}  # 선물 주고 받은 기록
    gift_info = {i: [0, 0, 0] for i in friends}  # 준 선물, 받은 선물, 선물 지수
    check = {i: False for i in friends}
    answer = {i: 0 for i in friends}
    
    for i in gifts:
        frm, to = i.split()
        network[frm][to] += 1
        gift_info[to][1] += 1

    for i in friends:
        gift_info[i][0] += sum(network[i].values())
        gift_info[i][2] = gift_info[i][0] - gift_info[i][1]
        
    for i in friends:
        for j in friends:
            if i == j or check[j]:  # 자기 자신 제외
                continue
            if network[i][j] == network[j][i]:  # 두 사람이 선물을 주고 받은 기록이 없거나 같다면
                if gift_info[i][2] == gift_info[j][2]:  # 선물 지수가 같다면
                    continue
                if gift_info[i][2] > gift_info[j][2]:
                    answer[i] += 1
                else:
                    answer[j] += 1
            else:
                if network[i][j] > network[j][i]:
                    answer[i] += 1
                else:
                    answer[j] += 1
        check[i] = True  # 이미 검사 했으므로 다음 확인에서 검사할 필요가 없음    

    return max(answer.values())
