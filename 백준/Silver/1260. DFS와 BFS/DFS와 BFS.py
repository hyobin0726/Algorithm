from collections import deque
n,m,v = map(int,input().split())
graph=[[]for i in range(n+1)]
visited1=[False]*(n+1)
for i in range (m):
    a,b=map(int,input().split())
    graph[a].append(b)
    graph[b].append(a)

for i in graph: #정렬 추가
    i.sort()

def dfs(v):
    visited1[v]=True
    print(v,end=' ')
    for i in graph[v]:
        if visited1[i]==False:
            dfs(i)
dfs(v)
print()

visited2=[False]*(n+1)
def bfs(v):
    queue=deque()
    queue.append(v)
    visited2[v]=True

    while queue:
        v=queue.popleft()
        print(v, end=' ')
        for i in graph[v]:
            if visited2[i]==False:
                queue.append(i)
                visited2[i]=True
bfs(v)