n,m=map(int,input().split())

visited=[0]*(n+1)
arr=[]

def dfs(start):
    if len(arr) == m:
        print(*arr)
        return
    for i in range (start,n+1):
        if visited[i]:
            continue
        visited[i]=True
        arr.append(i)
        dfs(i+1)
        visited[i]=False
        arr.pop()
dfs(1)