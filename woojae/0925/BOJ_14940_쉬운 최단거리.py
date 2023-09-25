from collections import deque


class main:
    def __init__(self):
        self.n, self.m = map(int, input().split())
        self.target_y = 0  # 탐색을 시작할 위치
        self.target_x = 0
        self.maps = [list(map(int, input().split())) for _ in range(self.n)]
        self.grid = [[-1] * self.m for _ in range(self.n)]  # 밟을 수 있는 땅이더라도 접근할 수 없는 곳은 -1로 표시해야 하므로 처음부터 모든 값을 -1로 초기화
        self.visited = [[False] * self.m for _ in range(self.n)]  # 이전에 방문한 곳은 방문하면 안 되므로 방문 여부를 체크
        self.direction = [[-1, 0], [1, 0], [0, -1], [0, 1]]  # 방향벡터

    def search_start(self):
        for y in range(self.n):
            for x in range(self.m):
                if self.maps[y][x] == 0 or self.maps[y][x] == 2:  # 원래 맵에서 밟을 수 없는 땅이거나 목표 지점이라면
                    if self.maps[y][x] == 2:  # 탐색 위치라면
                        self.target_y = y
                        self.target_x = x
                    self.grid[y][x] = 0  # 원래 값으로 매핑
                    self.visited[y][x] = True  # 해당 포인트들을 방문하지 않기 위해 미리 방문처리

    def solve(self):
        self.search_start()  # 탐색 포인트 설정
        q = deque([[self.target_y, self.target_x]])  # 큐는 2개의 값을 가지는 리스트를 저장하는 리스트 형태로 초기화한다.
        while q:
            y, x = q.popleft()
            for d in self.direction:  # 방향 벡터에 따라
                my, mx = y + d[0], x + d[1]  # 이동할 포인트 갱신
                if 0 <= my < self.n and 0 <= mx < self.m and not self.visited[my][mx]:  # 해당 포인트가 유효할 경우
                    self.grid[my][mx] = self.grid[y][x] + 1  # 이전 값에 따라 값 갱신
                    self.visited[my][mx] = True
                    q.append([my, mx])

        for i in self.grid:
            print(*i)


problem = main()
problem.solve()
