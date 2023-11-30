from heapq import *

def solution(n, works):
    hq = []
    for i in works:  # 야근 지수를 낮추기 위해 작업량이 큰 것부터 처리함 -> 제곱의 합을 최소화하려면 큰 수를 작게 만들어야 함
        heappush(hq, -i)  # 최대힙

    while n > 0 and hq:  # 근무 시간이 남아있고 잔업이 있다면
        work = heappop(hq) + 1  # 잔업량 감소 -> 어차피 나중에 제곱을 하기 때문에 음수라도 상관없음
        if work != 0:  # 다 끝내지 못한 작업이라면
            heappush(hq, work)
        n -= 1
    if n > 0:  # 근무 시간이 남아 있다는 것은 모든 잔업을 마쳤다는 의미이므로 야근하지 않아도 됨
        return 0
    
    return sum(i**2 for i in hq)  # 위에서 반환되지 않았다는 것은 잔업이 남아있다는 것을 의미
