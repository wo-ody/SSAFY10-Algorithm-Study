class Main:
    def __init__(self):
        self.n = int(input())
        self.memory = list(map(int, input().split()))
        self.answer = [0] * self.n

    def solve(self):
        for i in range(self.n):
            cnt = 0  # i보다 큰 사람의 수
            for j in range(self.n):
                people = self.memory[i]
                if cnt == people and self.answer[j] == 0:  # 기억하는 큰 사람들의 수와 일치하며 아직 위치하는 사람이 없으면
                    self.answer[j] = i + 1  # 정답 포맷에 맞춰 보정
                    break
                if self.answer[j] == 0:  # 내 왼족으로 큰 사람이 들어올 곳이 있다면
                    cnt += 1

        print(*self.answer)


problem = Main()
problem.solve()
