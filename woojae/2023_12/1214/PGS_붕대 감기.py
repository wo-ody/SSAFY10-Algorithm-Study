def solution(bandage, health, attacks):
    answer = health
    t, x, y = bandage
    time = 1  # 초기 상태는 고려할 필요 없기 때문에 1로 시작
    
    for i in attacks:
        attack_time, damage = i
        period = attack_time-time  # 현재 시점에서 다음 공격이 이뤄지기 까지의 기간
        # 회복 단계
        if period != 0:  # period가 0인 경우: 연속적으로 공격이 들어오는 경우
            answer = min(answer + (x * period) + (y * (period//t)), health)  # 최대 체력을 넘길 수 없도록 제한
            # 현재 체력 + 기간 동안의 총 회복량 + 연속 성공했을 경우 추가 회복량
            # 공격을 당하기 전까지는 연속 성공의 횟수가 유효하므로 해당 기간 동안 시전 시간을 나눈만큼 추가 회복할 수 있음
        # 공격 이후
        answer -= damage
        time = attack_time+1  # 다음 시점은 공격 시점 이후
        if answer <= 0:  # 플레이어 사망
            answer = -1
            break
    
    return answer
