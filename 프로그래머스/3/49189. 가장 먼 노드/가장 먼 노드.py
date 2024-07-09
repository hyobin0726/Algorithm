from collections import deque

def solution(n, edge):
    graph = [[] for i in range (n+1)]
    visited = [0] * (n+1)
    for i in edge : 
        a=i[0]
        b=i[1]
        graph[a].append(b)
        graph[b].append(a)
        
    q = deque()
    q.append(1)
    visited[1] = 1

    while q:
        x = q.popleft() 
        for i in graph[x]:
            if not visited[i]:
                visited[i] = visited[x] + 1 
                q.append(i)
    answer = visited.count(max(visited))
        
    return answer