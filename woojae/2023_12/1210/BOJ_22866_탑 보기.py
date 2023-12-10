import math


class Main:
    def __init__(self):
        self.n = int(input())
        self.buildings = [[i, height] for i, height in enumerate(list(map(int, input().split())), 1)]
        self.cnt = [0] * (self.n + 1)
        self.nearest = [[-1, math.inf] for _ in range(self.n + 1)]

    def search(self, buildings):
        s = []  # s[i][0]: 건물 번호, s[i][1]: 해당 건물의 높이
        for i, height in buildings:  # 건물 번호 1번부터
            while s and s[-1][1] <= height:  # 스택에 마지막으로 기록된 건물의 높이가 현재 건물의 높이보다 같거나 작다면
                s.pop()  # 해당 건물에서는 볼 수 없으므로 제거
            self.cnt[i] += len(s)  # 현재 건물에서 볼 수 있는 건물의 수 갱신
            self.find_nearst(s, i)  # 가장 가까운 건물 탐색
            s.append([i, height])  # 현재 건물 기준 정보 갱신이 끝났다면 해당 건물을 스택에 저장
            
    def find_nearst(self, s, i):  # nearst[i][0]: 가장 가까운 건물, nearst[i][1]: 그 건물과 현재 건물(i)과의 거리
        if len(s) > 0:
            dist = abs(s[-1][0] - i)  # 현재 건물 기준 가장 가까운 건물의 거리
            if dist < self.nearest[i][1]:  # 건물의 거리가 현재 갱신된 정보보다 가깝다면
                self.nearest[i][0] = s[-1][0]  # 건물 정보 저장
                self.nearest[i][1] = dist  # 건물 거리 저장
            elif dist == self.nearest[i][1] and s[-1][0] < self.nearest[i][0]:  # 거리는 같은데 건물번호가 더 작은 경우
                self.nearest[i][0] = s[-1][0]

    def solve(self):
        self.search(self.buildings)
        self.search(reversed(self.buildings))

        for i in range(1, self.n+1):
            print(f'{self.cnt[i]} {self.nearest[i][0]}') if self.cnt[i] else print(0)


problem = Main()
problem.solve()
