n,m=map(int,input().split())

visited=[0]*(n+1)
arr=[]

def dfs():
    if len(arr) == m:
        print(*arr)
        return
    for i in range (1,n+1):
        if visited[i]:
            continue
        visited[i]=True
        arr.append(i)
        dfs()
        visited[i]=False
        arr.pop()
dfs()