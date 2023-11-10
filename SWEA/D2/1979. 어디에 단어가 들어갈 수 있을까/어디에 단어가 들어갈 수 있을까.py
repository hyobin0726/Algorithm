T=int(input())
for tc in range (1,T+1):
  n, k = map(int,input().split())
  graph = []
  cnt=0 
  
  for i in range(n):
    graph.append(list(map(int,input().split())))
  #가로 
  for i in range(n):
    a=0 
    for j in range(n):    
      if graph[i][j] == 1:
        a +=1
      if graph[i][j] == 0 or j == (n-1): #0이거나 가로 마지막이라면
        if a == k:
          cnt+=1
        if graph[i][j] == 0 :
          a=0
  #세로
  for j in range(n):
    a=0 
    for i in range(n):    
      if graph[i][j] == 1:
        a +=1
      if graph[i][j] == 0 or i == (n-1): #0이거나 가로 마지막이라면
        if a == k:
          cnt+=1
        if graph[i][j] == 0 :
          a=0
  print("#{} {}".format(tc,cnt))
