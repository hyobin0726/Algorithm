import sys
input = sys.stdin.readline

def dfs(x,y,cnt):
    global mx_cnt
    mx_cnt=max(mx_cnt,cnt)

    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if nx > r-1  or ny > c-1  or nx < 0 or ny < 0:
            continue
        if graph[nx][ny] not in alpha:
            alpha.add(graph[nx][ny])
            dfs(nx,ny,cnt+1)
            alpha.remove(graph[nx][ny])
    return mx_cnt

r,c=map(int,input().split())
graph = []
for i in range(r):
    graph.append(list(map(str,input())))
alpha=set(graph[0][0])
dx = [1, -1, 0, 0]
dy = [0, 0, -1, 1]
mx_cnt=1

dfs(0,0,mx_cnt)
print(mx_cnt)