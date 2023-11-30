from collections import deque

def bfs(begin, target, words):
    q = deque([])
    q.append([begin, 0])  # 단어, 변환된 횟수
    
    while q:
        begin, cnt = q.popleft()
        if begin == target:  # 확인할 단어가 타겟이라면
            return cnt  # 지금까지 변환된 횟수 반환
        for word in words:  # 확인할 단어들을 단어 집합에 모든 단어들이랑 매칭
            check = 0  # 다른 문자 개수
            for i, j in zip(word, begin):  # 단어의 길이는 모두 동일
                if i != j:  # 각 자리의 문자가 서로 다른 문자라면
                    check += 1  # 다른 문자의 개수 갱신
            if check == 1:  # 단어에서 문자는 하나만 변경가능
                q.append([word, cnt+1])  # 변환된 문자 저장
                
    
def solution(begin, target, words):
    if target not in words:  # 단어 집합에 타켓이 없다면 만들 수 없음
        return 0
    return bfs(begin, target, words)
