import sys
input = lambda: sys.stdin.readline().rstrip()


class Main:
    def __init__(self):
        self.n = int(input())
        self.arr = [list(map(int, input().split())) for _ in range(self.n)]
        self.a, self.b, self.c, self.d = [], [], [], []
        self.hash = dict()
        self.answer = 0

    def init_arr(self):
        for i in self.arr:
            self.a.append(i[0])
            self.b.append(i[1])
            self.c.append(i[2])
            self.d.append(i[3])

    def solve(self):
        self.init_arr()

        for a in self.a:
            for b in self.b:
                key = a+b
                if key in self.hash.keys():  # a+b를 키를 가지는 해시맵 생성
                    self.hash[key] += 1
                else:
                    self.hash[key] = 1

        for c in self.c:
            for d in self.d:
                key = -(c+d)  # c+d를 음수를 취한 값이 존재하는지 확인, -(c+d)가 존재한다는 것은 a+b가 c+d와 같지만 반대인 것을 의미
                if key in self.hash.keys():
                    self.answer += self.hash[key]

        print(self.answer)


problem = Main()
problem.solve()
