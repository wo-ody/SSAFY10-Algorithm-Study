from heapq import *
import math

def solution(n, costs):
    graph = {i: [] for i in range(n)}
    for start, to, cost in costs:
        graph[start].append([cost, to])
        graph[to].append([cost, start])

    return dijkstra(graph)


def dijkstra(graph):
    cost = [math.inf] * len(graph)
    visited = [False] * len(graph)
    hq = []
    cost[0] = 0
    heappush(hq, [cost[0], 0])

    while hq:
        current = heappop(hq)
        visited[current[1]] = True

        for nxt in graph[current[1]]:  # nxt[0]: 현재 노드에서 다음 노드로 가는 데 걸리는 비용, nxt[1]: 다음 노드
            if not visited[nxt[1]] and nxt[0] < cost[nxt[1]]:  # 어느 노드에서 특정노드까지 걸리는 최소 비용이 아님
                cost[nxt[1]] = nxt[0]
                heappush(hq, [cost[nxt[1]], nxt[1]])

    return sum(cost)
