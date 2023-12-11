from collections import deque


class Main:
    def __init__(self):
        self.n = int(input())
        self.x, self.y = map(int, input().split())
        self.m = int(input())
        self.nodes = [list(map(int, input().split())) for _ in range(self.m)]
        self.graph = {i: [] for i in range(1, self.n+1)}
        self.answer = [0 for _ in range(self.n+1)]

    def init_graph(self):
        for x, y in self.nodes:
            self.graph[x].append(y)
            self.graph[y].append(x)

    def search(self, start):
        q = deque([start])
        visited = [False for _ in range(self.n + 1)]
        visited[start] = True

        while q:
            node = q.popleft()

            for i in self.graph[node]:
                if not visited[i]:
                    q.append(i)
                    self.answer[i] = self.answer[node]+1  # node와 i의 촌수 -> 궁극적으로 start 노드 기준 촌수들이 계산
                    visited[i] = True

    def solve(self):
        self.init_graph()
        self.search(self.x)
        print(self.answer[self.y] if self.answer[self.y] else -1)


problem = Main()
problem.solve()
