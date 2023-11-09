T = int(input())
for tc in range(1,T+1):
  n=int(input())
  board = [[0 for _ in range(n)] for  _ in range(n)]
  
  #좌,하,우,상
  dx=[0,1,0,-1]
  dy=[1,0,-1,0]
  
  x,y=0,0
  dist=0 #좌:0
  
  for i in range(1, n*n+1):
    board[x][y] = i
    x=x+dx[dist]
    y=y+dy[dist]
    
    
    if x<0 or x>=n or y<0 or y>=n or board[x][y]!=0:
      x -= dx[dist]
      y -= dy[dist]
    
      dist = (dist+1)%4
      
      x += dx[dist]
      y += dy[dist]
  print("#{}".format(tc))  
  for i in board:
    print(*i)
       