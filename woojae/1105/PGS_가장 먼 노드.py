from collections import deque

def bfs(graph):
    q = deque([[0, 0]])  # node, distance
    result = []
    visited = [False] * len(graph)
    visited[0] = True
    
    while q:
        node, dist = q.popleft()
        for nxt in graph[node]:
            if not visited[nxt]:
                q.append([nxt, dist+1])
                result.append([nxt, dist+1])  # 도착 노드와 해당 노드까지 걸린 거리를 저장
                visited[nxt] = True
    
    return result
    

def solution(n, edge):
    answer = 0
    graph = {i: [] for i in range(n)}
    for e in edge:
        graph[e[0]-1].append(e[1]-1)
        graph[e[1]-1].append(e[0]-1)
    
    result = bfs(graph)
    max_distance = result[-1][1]  # 마지막에 있는 값이 가장 먼 노드
    for i in range(n-2, -1, -1):  # 뒤에서부터
        if result[i][1] == max_distance:  # 해당 값이 가장 먼 노드와 일치한다면
            answer += 1  # 정답 갱신
        else:  # 아니라면 -> 가장 먼 노드들 탐색 완료
            break
    return answer