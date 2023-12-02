from collections import deque
n,k = map(int,input().split())
visited=[0]*(100001)

def bfs():
    queue = deque()
    queue.append(n)

    while queue:
        x=queue.popleft()

        if x == k :
            print(visited[x])
            return x
        for i in (2*x,x-1,x+1):
            if 0<= i < 100001 and visited[i] == 0:
                if i == (2*x):
                    visited[i] =visited[x]
                    queue.append(i)
                else:
                    visited[i] = visited[x]+1
                    queue.append(i)

bfs()