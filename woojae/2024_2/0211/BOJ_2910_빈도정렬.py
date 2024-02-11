class Main:
    def __init__(self):
        self.n, self.c = map(int, input().split())
        self.arr = list(map(int, input().split()))
        self.hash = {}

    def solve(self):
        for i, num in enumerate(self.arr):
            if num not in self.hash:
                self.hash[num] = [i, num, 1]
            else:
                self.hash[num][2] += 1

        result = sorted(list(self.hash.values()), key=lambda x: (-x[2], x[0]))

        for i in result:
            for _ in range(i[2]):
                print(i[1], end=' ')


problem = Main()
problem.solve()
