T=int(input())
for tc in range (1,T+1):
    n=int(input())
    graph=[[0]*n for _ in range (n)]
    cnt=0
    result=[[]*n for _ in range(n)]
    for i in range (n):
        for j in range (n):
            if graph[i][j]==0:
                cnt+=1
                graph[i][j]=cnt
        for k in range (n):
            if graph[k][j] == 0:
                cnt+=1
                graph[k][j]=cnt
        for l in range (n-1,-1,-1):
            if graph[k][l] == 0:
                cnt+=1
                graph[k][l]=cnt
        for m in range ( n-1,-1,-1):
            if graph[m][l] == 0:
                cnt+=1
                graph[m][l]=cnt
    print("#{}".format(tc))
    for i in range(n):
        print(*graph[i])
