from collections import deque

def solution(maps):
    dx=[1,-1,0,0]
    dy=[0,0,1,-1]

      
    visited=[[0]* len(maps[0]) for _ in range (len(maps))]
    visited[0][0]=1
    queue=deque()
    queue.append((0,0))
        
    while queue:
        x,y=queue.popleft()
            
        for i in range(4):
            nx=x+dx[i]
            ny=y+dy[i]
                
                
            if 0<= nx<len(maps) and 0<=ny<len(maps[0]) and not visited[nx][ny]:
                if maps[nx][ny] ==1:
                    visited[nx][ny]=1
                    queue.append((nx,ny))
                    maps[nx][ny]= maps[x][y]+1
                    
        
    if maps[len(maps)-1][len(maps[0])-1]==1:
        return -1
    else:
        return maps[len(maps)-1][len(maps[0])-1]