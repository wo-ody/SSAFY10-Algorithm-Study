from heapq import *
import sys


class Main:
    def __init__(self):
        self.t = int(input())
        self.minQ, self.maxQ = None, None
        self.log = None

    def solve(self):  # 프로그래머스와는 테스트케이스가 다름
        for _ in range(self.t):
            k = int(input())
            self.minQ, self.maxQ = [], []
            self.log = dict()
            for _ in range(k):
                cmd, num = sys.stdin.readline().rstrip().split()
                num = int(num)
                if cmd == "I":
                    if num in self.log:  # 사실상 큐 하나에서 동작하는 것과 마찬가지 이므로 동기화를 위해 값 기록
                        self.log[num] += 1  # 큐에 들어와 있는 값들의 개수
                    else:
                        self.log[num] = 1
                    heappush(self.minQ, num)
                    heappush(self.maxQ, -num)
                else:
                    param = [(self.minQ, 1) if num == -1 else (self.maxQ, -1)]  # 연산에 따라 다른 인자 넘겨줌
                    self.synchronize(param[0][0], param[0][1])

            q = [i[0] for i in self.log.items() if i[1] >= 1]  # 딕셔너리에 존재하는 0보다 큰 값들은 연산이 끝난 후 남아있는 값
            print("EMPTY" if not q else f'{max(q)} {min(q)}')
            
    def synchronize(self, q, op):  # 동기화
        while q:  # 한 쪽 큐에만 남아있는 경우는(값이 0이하) 해당 큐에서만 제거하고 다른 값 탐색
            node = op * heappop(q)  # op에 따라 다른 값 체크 -> 최대힙의 값이 음수이므로 이를 되돌리기 위한 연산
            if self.log[node] > 0:  # 그렇지 않고 양쪽 큐에 존재하는 값을 제거했다면 반복 종료
                self.log[node] -= 1
                break


problem = Main()
problem.solve()
