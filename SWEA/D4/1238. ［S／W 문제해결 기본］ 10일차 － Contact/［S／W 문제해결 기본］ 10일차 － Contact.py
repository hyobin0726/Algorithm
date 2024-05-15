from collections import deque

def bfs(start):
    visited = [0] * 101
    q=deque()
    q.append((start))
    visited[start]=1
    ans = start
    while q :
        x=q.popleft()
        if visited[ans] < visited[x] or (visited[ans]==visited[x] and ans<x) :
            ans=x
        for i in contact[x]:
            if not visited[i]:
                q.append((i))
                visited[i]=visited[x]+1
    return ans
for test in range(1,11):
    t,start=map(int,input().split())
    data=list(map(int,input().split()))
    contact=[[]for i in range(101)]
    for i in range (0,t,2):
        a,b = data[i],data[i+1]
        contact[a].append(b)
    
    ans=bfs(start)
    print("#{} {}".format(test,ans))
