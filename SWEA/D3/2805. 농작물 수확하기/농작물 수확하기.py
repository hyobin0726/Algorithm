T=int(input())
for test_case in range(1,T+1):
  n=int(input())
  graph=[]
  for i in range(n):
    graph.append(list(map(int,input())))
  start=n//2
  cnt=0
  for i in range(start+1):
    for j in range(start-i,start+i+1):
      cnt+=graph[i][j]+graph[n-1-i][j]


  cnt=(cnt-sum(graph[start]))
  print(f'#{test_case}',cnt)
