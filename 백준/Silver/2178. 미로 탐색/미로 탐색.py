from collections import deque

n, m = map(int, input().split())
graph = []

for _ in range(n):
    graph.append(list(map(int, input().strip())))  # 공백 없애기 위해 strip 사용

visited = [[False] * m for _ in range(n)]

direction = [(0, 1), (0, -1), (1, 0), (-1, 0)]

def bfs(x, y):
    queue = deque()
    queue.append((x, y))
    visited[y][x] = True

    while queue:
        x, y = queue.popleft()

        for dy, dx in direction:
            ny = y + dy
            nx = x + dx

            if 0 <= nx < m and 0 <= ny < n and not visited[ny][nx] and graph[ny][nx] == 1:
                queue.append((nx, ny))
                visited[ny][nx] = True
                graph[ny][nx] = graph[y][x] + 1

    return graph[n-1][m-1]
    
print(bfs(0, 0))