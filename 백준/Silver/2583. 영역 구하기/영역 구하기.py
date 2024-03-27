from collections import  deque
def bfs(x,y):
    global area
    queue=deque()
    queue.append((x,y))

    while queue :
        x,y=queue.popleft()

        for i in range (4):
            nx=x+dx[i]
            ny=y+dy[i]

            if 0<=nx<m and 0<=ny<n :
                if not visited[nx][ny] and graph[nx][ny] == 0:
                    visited[nx][ny]=True
                    queue.append((nx,ny))
                    area+=1
    area_cnt.append(area)


m,n,k=map(int,input().split())
graph=[[0]*n for _ in range(m)]

for i in range(k):
    x1,y1,x2,y2=map(int,input().split())

    for j in range (y1,y2):
        for k in range (x1,x2):
            graph[j][k] =1

dx=[1,-1,0,0]
dy=[0,0,1,-1]

visited=[[False]*n for _ in range(m)]

date=0
area=0
area_cnt=[]
for i in range (m):
    for j in range (n):
        if graph[i][j] == 0 and not visited[i][j]:
            visited[i][j]=True
            date+=1
            area=1
            bfs(i,j)

print(date)
area_cnt.sort()
for i in area_cnt:
    print(i,end=' ')