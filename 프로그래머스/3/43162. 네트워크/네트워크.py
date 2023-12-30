def dfs(n,computers,i,visited):
    visited[i]=True
    for j in range(n):
        if computers[i][j] and not visited[j]:
            dfs(n,computers,j,visited)
def solution(n, computers):
    answer =0 
    visited = [False]*n
    for i in range (n):
        if not visited[i]:
            dfs(n,computers,i,visited)
            answer+=1
    return answer
    