def solution(n):
    val = 1  # 첫 삽입할 값
    cur = 0  # 방향벡터 커서
    d = [[0, 1], [1, 0], [0, -1], [-1, 0]]  # →, ↓, ←, ↑ 순으로 방향벡터 정의
    answer = [[0 for _ in range(n)] for _ in range(n)]  # 정답을 기록할 배열 생성
    y, x = 0, 0  # 첫 시작 위치
    while val <= n**2:  # 모든 값을 채울 수 있을 때까지
        if 0 <= y < n and 0 <= x < n and answer[y][x] == 0:  # 현재 좌표가 유효범위이면서 값을 기록할 수 있다면
            answer[y][x] = val  # 값 저장
            val += 1  # 저장할 값 갱신
        else:  # 값을 저장할 수 없는 위치라면
            y -= d[cur][0]  # 이전 위치로 복귀
            x -= d[cur][1]
            cur = (cur + 1) % 4  # 모든 방향을 다 돌았을 때 첫 방향으로 돌아올 수 있도록 모듈러 연산 사용
        y += d[cur][0]  # 이동
        x += d[cur][1]

    return answer
