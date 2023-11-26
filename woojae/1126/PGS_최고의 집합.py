''' 오답 - 부르트포스
from itertools import combinations_with_replacement as comb
from functools import reduce

def solution(n, s):
    if s < n:
        return [-1]
    answer = []
    best = 0
    for i in list(comb(range(1, s // 2 + 2), n)):
        if sum(i) == s:
            if best < reduce(lambda x, y: x * y, i):
                answer = i

    return answer
'''

def solution(n, s):
    if s < n:
        return [-1]
    element, specific = divmod(s, n)  # n개의 수로 곱을 최대를 만들기 위해 균등 분배된 리스트가 필요
    answer = [element] * n
    for i in range(1, specific+1):  # 오름 차순이라는 조건을 만족하기 위해 뒤에서부터
        answer[-1 * i] += 1  # 목표하는 수를 만들 때, 균등 분배 후 나머지가 있다면 나머지 역시 뒤에서부터 균등 분배
    return answer
