c=int(input())
p=int(input())
graph=[[]for i in range(c+1)]
visited=[False]*(c+1)
cnt=0
for i in range(p):
    a,b=map(int,input().split())
    graph[a].append(b)
    graph[b].append(a)


def dfs(v):
    visited[v]=True
    global cnt
    for i in graph[v]:
        if visited[i]==False:
            cnt+=1
            dfs(i)

dfs(1)
print(cnt)