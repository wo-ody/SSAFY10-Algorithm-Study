import sys
import heapq
import math
input = lambda: sys.stdin.readline()


class Main:
    def __init__(self):
        self.n, self.e = map(int, input().split())
        self.graph = [[] for _ in range(self.n + 1)]
        for i in range(self.e):
            start, end, cost = map(int, input().split())
            self.graph[start].append([end, cost])
            self.graph[end].append(([start, cost]))
        self.v1, self.v2 = map(int, input().split())
        self.inf = math.inf

    def dijkstra(self, start, end):
        cost = [self.inf] * (self.n + 1)
        pq = []
        heapq.heappush(pq, (0, start))
        cost[start] = 0

        while pq:
            current_cost, current = heapq.heappop(pq)
            if cost[current] < current_cost:
                continue

            for nxt, next_cost in self.graph[current]:
                if current_cost + next_cost < cost[nxt]:
                    cost[nxt] = current_cost + next_cost
                    heapq.heappush(pq, (current_cost + next_cost, nxt))
        return cost[end]

    def solve(self):
        path1 = self.dijkstra(1, self.v1) + self.dijkstra(self.v1, self.v2) + self.dijkstra(self.v2, self.n)
        path2 = self.dijkstra(1, problem.v2) + self.dijkstra(self.v2, self.v1) + self.dijkstra(self.v1, self.n)
        print(-1) if path1 >= problem.inf and path2 >= problem.inf else print(min(path1, path2))


problem = Main()
problem.solve()
