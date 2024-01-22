from collections import deque

f, s, g, u, d = map(int, input().split())
# 상하
dy = [u, -d]

visited = [0] * (f + 1)

def bfs():
    q = deque()
    q.append(s)

    visited[s] = 1

    while q:
        floor = q.popleft()

        if floor == g:
            return visited[floor] - 1
        for i in range(2):
            ny = floor + dy[i]
            if 1 <= ny <= f and not visited[ny]:
                visited[ny] = visited[floor] + 1
                q.append(ny)
        
    return "use the stairs"

print(bfs())