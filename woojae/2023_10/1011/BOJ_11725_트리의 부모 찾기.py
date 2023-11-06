from collections import deque
import sys


class Main:
    def __init__(self):
        self.n = int(sys.stdin.readline().rstrip())
        self.tree = {i: [] for i in range(1, self.n+1)}
        for _ in range(self.n-1):  # 트리처럼 구성할 필요 없고 양방향 그래프로 구성하면 1번 정점에서 모든 정점 방문 가능
            p, c = map(int, sys.stdin.readline().rstrip().split())
            self.tree[p].append(c)
            self.tree[c].append(p)
        self.visited = [False] * (self.n+1)  # 양방향 그래프라 사이클이 발생할 수 있기에 방문 체크를 해줘야 함
        self.answer = [0] * (self.n+1)

    def solve(self):
        q = deque([1])
        self.visited[1] = True
        while q:
            child = q.popleft()
            for parent in self.tree[child]:
                if not self.visited[parent]:
                    self.visited[parent] = True
                    q.append(parent)
                    self.answer[parent] = child

        temp = ""
        for i in self.answer[2:]:
            temp += str(i)+"\n"
        print(temp)


problem = Main()
problem.solve()
