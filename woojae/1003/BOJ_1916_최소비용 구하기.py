import sys
import math
from heapq import *

input = sys.stdin.readline


class Node:
    def __init__(self, destination, cost):
        self.destination = destination
        self.cost = cost

    def __lt__(self, other):
        return self.cost < other.cost


class main:  # 입력이 엄첨 길기 때문에 입력받을 때 처리받지 않으면 시간 초과 발생
    def __init__(self):
        self.n = int(input())
        self.m = int(input())
        self.adj = {i: [] for i in range(1, self.n + 1)}
        for _ in range(self.m):
            departure, destination, cost = map(int, input().split())
            self.adj[departure].append(Node(destination, cost))
        self.a, self.b = map(int, input().split())
        self.cost = [math.inf for _ in range(self.n + 1)]
        self.visited = [False for _ in range(self.n + 1)]

    def solve(self):
        hq = []
        self.cost[self.a] = 0
        heappush(hq, Node(self.a, self.cost[self.a]))

        while hq:
            current = heappop(hq)
            if self.visited[current.destination]:
                continue
            self.visited[current.destination] = True

            for nxt in self.adj[current.destination]:
                if self.cost[current.destination] + nxt.cost < self.cost[nxt.destination]:
                    self.cost[nxt.destination] = self.cost[current.destination] + nxt.cost
                    heappush(hq, Node(nxt.destination, self.cost[nxt.destination]))

        print(self.cost[self.b])


problem = main()
problem.solve()
