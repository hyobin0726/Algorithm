from collections import deque
n,k = map(int,input().split())
visited=[0]*(100001)
point=[0]*(100001)

def move(x):
    graph=[]
    temp=x
    for _ in range(visited[x]+1):
        graph.append(temp)
        temp = point[temp]
    print(' '.join(map(str,graph[::-1])))
        

def bfs():
    queue = deque()
    queue.append(n)

    while queue:
        x=queue.popleft()

        if x == k :
            print(visited[x])
            move(x)
            return x
        for i in (x-1,x+1,2*x):
            if 0<= i < 100001 and visited[i] == 0:
                visited[i] =visited[x]+1
                queue.append(i)
                point[i]=x
                
bfs()