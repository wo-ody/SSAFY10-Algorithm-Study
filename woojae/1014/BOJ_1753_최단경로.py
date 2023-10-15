import math
import sys
from heapq import *


class Node:
    def __init__(self, vertex, cost):
        self.vertex = vertex
        self.cost = cost

    def __lt__(self, other):
        if self.cost < other.cost:
            return True


class Main:
    def __init__(self):
        self.v, self.e = map(int, sys.stdin.readline().rstrip().split())
        self.k = int(input())
        self.graph = {i+1: [] for i in range(self.v)}
        for _ in range(self.e):
            start, vertex, cost = map(int, sys.stdin.readline().rstrip().split())
            self.graph[start].append(Node(vertex, cost))
        self.cost = [math.inf] * (self.v + 1)

    def solve(self):
        hq = []
        self.cost[self.k] = 0
        heappush(hq, Node(self.k, self.cost[self.k]))

        while hq:
            current = heappop(hq)
            if self.cost[current.vertex] < current.cost:
                continue

            for nxt in self.graph[current.vertex]:
                if current.cost + nxt.cost < self.cost[nxt.vertex]:
                    self.cost[nxt.vertex] = current.cost + nxt.cost
                    heappush(hq, Node(nxt.vertex, self.cost[nxt.vertex]))

        for i in range(1, self.v+1):
            print(self.cost[i] if self.cost[i] != math.inf else "INF")  # math.inf를 그대로 출력하면 안 되고 INF로 맞춰야 함..


problem = Main()
problem.solve()
