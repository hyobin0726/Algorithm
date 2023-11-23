from collections import deque

def bfs(x, y):
    global area, mx_area
    queue = deque()
    queue.append((x, y))

    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx > n - 1 or ny > m - 1 or nx < 0 or ny < 0:
                continue
            if graph[nx][ny] == 1 and not visited[nx][ny]:
                queue.append((nx, ny))
                visited[nx][ny] = True
                area += 1

    if area > mx_area:
        mx_area = area

area = 0
mx_area = 0
n, m = map(int, input().split())
graph = []
for i in range(n):
    graph.append(list(map(int, input().split())))

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
visited = [[False] * m for _ in range(n)]

cnt = 0
for i in range(n):
    for j in range(m):
        if not visited[i][j] and graph[i][j] == 1:
            visited[i][j] = True
            area = 1
            bfs(i, j)
            cnt += 1

print(cnt)
print(mx_area)