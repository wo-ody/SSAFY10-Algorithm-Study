from collections import deque


class Main:
    def __init__(self):
        self.n = int(input())
        self.a = list(map(int, input().split()))
        self.count_arr = [0] * self.n

    def bfs(self, x):
        q = deque([x])

        while q:
            current_pos = q.popleft()
            # if current_pos == self.n-1:  # 해당 코드는 필요 없음 -> 도착 지점은 정해져있으므로
            #     break

            for i in range(current_pos+1, current_pos+self.a[current_pos]+1):
                if i < self.n and self.count_arr[i] == 0:
                    self.count_arr[i] += (self.count_arr[current_pos]+1)
                    q.append(i)

        print(self.count_arr[-1] if self.count_arr[-1] else -1)  # 도달할 수 없는 경우도 체크해야 함

    def solve(self):
        if self.n == 1:  # 칸이 하나라면 출발지가 곧 도착 -> n의 최소 범위는 1임
            print(0)
        else:
            self.bfs(0)


problem = Main()
problem.solve()
