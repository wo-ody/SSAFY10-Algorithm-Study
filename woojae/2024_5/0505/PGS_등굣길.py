def solution(m, n, puddles):
    grid = [[0] * m for _ in range(n)]
    grid[0][0] = 1

    for y in range(n):
        for x in range(m):
            if y == x == 0 or [x+1, y+1] in puddles:  # 시작 지점 밑 웅덩이 제외, 웅덩이의 좌표는 y, x가 반대임
                continue
            grid[y][x] = (grid[y-1][x] + grid[y][x-1]) % 1000000007

    return grid[-1][-1]
