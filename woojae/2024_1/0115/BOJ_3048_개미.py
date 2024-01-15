class Main:
    def __init__(self):
        self.n1, self.n2 = map(int, input().split())
        self.first_group = input()
        self.second_group = input()
        self.t = int(input())
        self.direction = dict()
        self.answer = list(self.first_group[::-1] + self.second_group)

    def solve(self):
        for i in range(len(self.answer)):
            if i < self.n1:
                self.direction[self.answer[i]] = 0
            else:
                self.direction[self.answer[i]] = 1

        for _ in range(self.t):
            i = 0
            while i < len(self.answer)-1:  # 혹시 위치를 바꿀 수 있으니 직전 이전까지만 검사
                if self.direction[self.answer[i]] == 0 and self.direction[self.answer[i+1]] == 1:
                    self.answer[i], self.answer[i+1] = self.answer[i+1], self.answer[i]
                    i += 1  # 현재 가리키던 개미가 다음으로 넘어갔으므로
                i += 1  # 순차적으로 개미 검사

        print(''.join(self.answer))


problem = Main()
problem.solve()
