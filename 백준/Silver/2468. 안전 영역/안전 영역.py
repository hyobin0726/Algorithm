from collections import deque

n = int(input())
graph = []
for i in range(n):
    graph.append(list(map(int, input().split())))
visited = [[False] * n for _ in range(n)]
dx = [1, -1, 0, 0]
dy = [0, 0, -1, 1]
result = []

def bfs(x,y,height,visited):
    queue = deque()
    queue.append((x,y))
    visited[x][y]=True

    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < n and 0 <= ny < n and not visited[nx][ny]  :
                if graph[nx][ny] > height:
                    visited[nx][ny] = True
                    queue.append((nx, ny))


for z in range(0,101):
    cnt = 0
    visited = [[False] * n for _ in range(n)]
    for i in range(n):
        for j in range(n):
            if not visited[i][j] and graph[i][j]>z:
                bfs(i,j,z,visited)
                cnt+=1
    result.append(cnt)


print(max(result))