class Main:
    def __init__(self):
        self.n = int(input())
        self.data = [input().split('.') for _ in range(self.n)]

    def solve(self):
        answer = {}
        for i in self.data:
            if i[1] not in answer:
                answer[i[1]] = 1
            else:
                answer[i[1]] += 1

        answer = sorted(list(answer.items()), key=lambda x:x[0])

        for i in answer:
            print(*i)


problem = Main()
problem.solve()
