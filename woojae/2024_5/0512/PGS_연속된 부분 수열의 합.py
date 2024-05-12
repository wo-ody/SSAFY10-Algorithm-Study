def solution(sequence, k):
    low = high = 0
    answer = [0, len(sequence)]  # 전체 범위
    target = sequence[0]

    while True:
        if target < k:
            high += 1
            if high == len(sequence):  # high가 배열 범위를 벗어났을 경우
                break
            target += sequence[high]  # 새로운 값이 추가됐으므로 값 합산
        else:  # 타겟과 같거나 작을 때
            if target == k:  # 타겟을 찾았다면
                if high - low < answer[1] - answer[0]:  # 또한 현재 수열보다 길이가 짧다면
                    answer = [low, high]  # 답 갱신
            target -= sequence[low]  # 필요없는 값이 됐으므로 제거 
            low += 1
            
    return answer
