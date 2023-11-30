def solution(board):
    answer = 0
    extend_board = [[0 for _ in range(len(board[0])+1)] for _ in range(len(board)+1)]  # 원 배열의 모든 요소를 반영하기 위해 배열 확장
    
    col, row = len(board), len(board[0])
    
    for i in range(1, col+1):
        for j in range(1, row+1):
            extend_board[i][j] = board[i-1][j-1]

    for i in range(1, col+1):
        for j in range(1, row+1):
            if extend_board[i][j] != 0:  # 최소한의 넓이를 보장하기 위해
                extend_board[i][j] = min(extend_board[i][j-1], extend_board[i-1][j-1], extend_board[i-1][j]) + 1
                answer = max(answer, extend_board[i][j])

    return answer**2
