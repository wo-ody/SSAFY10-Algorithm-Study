def solution(A, B):
    answer = 0
    A = sorted(A, reverse=True)  # 점수가 큰 순서대로 비교
    B = sorted(B, reverse=True)
    
    i = 0  # B팀의 점수를 가리킬 인덱스
    for a in A:
        if a < B[i]:  # 현재 A팀의 점수가 B팀의 점수보다 작다면
            answer += 1  # 승점 획득
            i += 1  # 다음 점수로 갱신
            
    return answer
