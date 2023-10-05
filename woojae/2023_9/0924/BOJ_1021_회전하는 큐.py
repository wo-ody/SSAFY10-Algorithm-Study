from collections import deque

class main:
    def __init__(self):
        self.n, self.m = map(int, input().split())
        self.indices = [i-1 for i in map(int, input().split())]
        self.answer = 0

    def solve(self):
        dq = deque(list(range(self.n)))
        i = 0

        while i < self.m:
            if self.indices[i] == dq[0]:  # 값의 제거는 항상 앞에서 이뤄져야 함
                dq.popleft()
                i += 1  # 목표하는 값을 제거했으므로 다음 값의 인덱스로 갱신
            else:
                if dq.index(self.indices[i]) <= len(dq) // 2:  # 제거할 값의 위치가 큐의 길이의 절반보다 앞선다면
                    dq.rotate(-1)  # 앞에서 뒤로 이동
                else:  # 그렇지 않으면
                    dq.rotate()  # 뒤에서 앞으로 이동
                self.answer += 1  # 해당 조건에 걸렸다는 것은 무조건 이동이 일어났다는 것을 의미
        print(self.answer)

main = main().solve()