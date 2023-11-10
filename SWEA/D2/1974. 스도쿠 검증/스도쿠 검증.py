T=int(input())
for tc in range(1,T+1):
  graph = []
  cnt=0 
  
  for i in range(9):
    graph.append(list(map(int,input().split())))
  
  #가로 
  for i in range(9):
    a=0 
    for j in range(9):
      a+=graph[i][j]
    if a == 45:
      cnt+=1
  #세로
  for j in range(9):
    a=0 
    for i in range(9): 
      a+=graph[i][j]
    if a == 45:
      cnt+=1
  #3x3
  for i in range(3):
    for j in range(3):
      a=0
      for k in range(3):
        for l in range(3):
          a+=graph[i*3+k][j*3+l]
      if a == 45:
        cnt+=1
  if cnt == 27:
    print("#{} {}".format(tc,1))
  else:
    print("#{} {}".format(tc,0))
