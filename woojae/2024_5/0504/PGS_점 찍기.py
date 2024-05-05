def solution(k, d):
    answer = 0
    for x in range(0, d+1, k):
        y = int((d**2 - x**2)**0.5)  # 원의 방정식을 통해 길이가 d가 되는 y를 계산
        answer += (y // k) + 1
        # 계산된 y를 k의 간격으로 나누면 최소 k의 높이를 가지면 k의 간격을 가지는 점의 수를 구할 수 있음
        # +1을 통해 높이가 없는 원점도 계산
    return answer
