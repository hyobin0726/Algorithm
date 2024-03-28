from collections import deque


def bfs(x,y):
    queue=deque()
    queue.append((x,y))

    while queue:
        x,y=queue.popleft()
        for i in range (4):
            nx = x+dx[i]
            ny = y+dy[i]

            if 0<=nx<n and 0<=ny<m:
                if not visited[nx][ny] and graph[nx][ny]==1 :
                    visited[nx][ny]=True
                    queue.append((nx,ny))

t=int(input())
for i in range(t):
    m,n,k=map(int,input().split())

    graph=[[0]*m for _ in range (n)]

    for i in range(k):
        a,b=map(int,input().split())
        graph[b][a]=1
    dx=[1,-1,0,0]
    dy=[0,0,1,-1]

    visited=[[False]*m for _ in range(n)]

    cnt=0
    for i in range (n):
        for j in range (m):
            if not visited[i][j] and graph[i][j]==1 :
                visited[i][j]=True
                cnt+=1
                bfs(i,j)

    print(cnt)