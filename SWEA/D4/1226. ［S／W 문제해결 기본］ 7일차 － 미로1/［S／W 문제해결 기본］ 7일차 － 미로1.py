from collections import deque
for t in range(1,11):
    n=int(input())
    graph=[]
    visited=[[0] * 16 for i in range (16)]
    dx=[1,-1,0,0]
    dy=[0,0,1,-1]

    for i in range(16):
        graph.append(list(map(int,input())))

    def bfs(x,y):
        global answer
        queue = deque()
        queue.append((x,y))

        while queue:
            a,b = queue.popleft()

            for i in range(4):
                nx = a+dx[i]
                ny = b+dy[i]

                if 0<=nx<16 and 0<=ny<16 and not visited[nx][ny]:

                    if graph[nx][ny] == 0:
                        visited[nx][ny]=1
                        queue.append((nx,ny))
                    elif graph[nx][ny] == 3:
                        answer=1


    answer=0
    for i in range(16):
        for j in range(16):
            if graph[i][j]==2:
                visited[i][j]=1
                bfs(i,j)
    print("#{} {}".format(t,answer))