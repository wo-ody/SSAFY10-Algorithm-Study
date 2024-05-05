def solution(topping):
    chulsu, brother = Counter(topping), set()
    answer = 0

    for i in topping:  # 케이크 자르기는 순차적으로 진행됨
        chulsu[i] -= 1  # 순서대로 토핑 제거
        brother.add(i)  # 제거한 토핑 추가

        if not chulsu[i]:  # 더 이상 제거할 토핑이 없다면
            chulsu.pop(i)  # 해당 토핑 완전 제거
        if len(chulsu) == len(brother):  # 형과 동생이 가진 토핑의 종류가 같다면
            answer += 1  # 케이크를 자르는 방법의 수 추가

    return answer
