direction = [[-1, 0], [1, 0], [0, -1], [0, 1]]

def solution(board, h, w):
    answer = 0
    for d in direction:
        mh, mw = h+d[0], w+d[1]
        if 0 <= mh < len(board) and 0 <= mw < len(board[0]):
            if board[h][w] == board[mh][mw]:
                answer += 1
    return answer
