from collections import deque
import copy
import sys

n, m = map(int, sys.stdin.readline().split())
graph = []
for i in range(n):
    graph.append(list(map(int, sys.stdin.readline().split())))
dx = [1, -1, 0, 0]
dy = [0, 0, -1, 1]
result = 0


def bfs():
    queue = deque()
    t_graph = copy.deepcopy(graph)
    for i in range(n):
        for j in range(m):
            if t_graph[i][j] == 2:
                queue.append((i, j))
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < n and 0 <= ny < m:
                if t_graph[nx][ny] == 0:
                    t_graph[nx][ny] = 2
                    queue.append((nx, ny))
    global result
    total = 0
    for i in range(n):
        for j in range(m):
            if t_graph[i][j] == 0:
                total += 1
    result=max(result,total)


def wall(cnt):
    if cnt == 3:
        bfs()
        return
    for i in range(n):
        for j in range(m):
            if graph[i][j] == 0:
                graph[i][j] = 1
                wall(cnt + 1)
                graph[i][j] = 0

wall(0)
print(result)
