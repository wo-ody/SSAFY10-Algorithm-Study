import math


class Main:
    def __init__(self):
        self.n = int(input())
        self.a = list(map(int, input().split()))
        self.op = list(map(int, input().split()))
        self.max_answer = -math.inf
        self.min_answer = math.inf

    def solve(self):
        self.dfs(1, self.a[0])
        print(self.max_answer)
        print(self.min_answer)

    def dfs(self, idx, target):
        if idx == self.n:
            self.max_answer = max(self.max_answer, target)
            self.min_answer = min(self.min_answer, target)
        else:
            if self.op[0] > 0:
                self.op[0] -= 1
                self.dfs(idx + 1, target + self.a[idx])
                self.op[0] += 1
            if self.op[1] > 0:
                self.op[1] -= 1
                self.dfs(idx + 1, target - self.a[idx])
                self.op[1] += 1
            if self.op[2] > 0:
                self.op[2] -= 1
                self.dfs(idx + 1, target * self.a[idx])
                self.op[2] += 1
            if self.op[3] > 0:
                self.op[3] -= 1
                self.dfs(idx + 1, -(-target // self.a[idx]) if target < 0 else target // self.a[idx])
                # 음수를 양수로 나눌 때는 음수를 양수로 바꾼 뒤 몫을 취하고, 그 몫을 음수로 바꾼다.
                self.op[3] += 1


problem = Main()
problem.solve()
