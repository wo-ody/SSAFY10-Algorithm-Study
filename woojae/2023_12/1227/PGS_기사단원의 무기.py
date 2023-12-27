def solution(number, limit, power):
    answer = [1]
    for i in range(2, number+1):
        temp = []
        for j in range(1, int(i**0.5)+1):  # 시간 단축
            if i % j == 0:  # i가 j로 나눠 떨어지면 j는 i의 약수
                temp.append(j)
                temp.append(i // j)  # j x (i // j) = 1 x 4, 2 x 2의 형태로 약수는 1, 2, 4가 됨
        answer.append(len(set(temp)))  # 중복되는 수를 하나의 약수로 표현
    return sum([i if i <= limit else power for i in answer])  # 조건에 맞춰 필터링 후 합산
