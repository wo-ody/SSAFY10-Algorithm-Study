import sys
input = lambda: sys.stdin.readline()


class Main:
    def __init__(self):
        self.t = int(input())
        self.answer = []

    def solve(self):
        for _ in range(self.t):
            n, m = map(int, input().split())
            visited = [0] * n
            for _ in range(m):
                a, b = map(int, input().split())
                visited[a-1] = 1
                visited[b-1] = 1

            self.answer.append(sum(visited)-1)

        for a in self.answer:
            print(a)


problem = Main()
problem.solve()
