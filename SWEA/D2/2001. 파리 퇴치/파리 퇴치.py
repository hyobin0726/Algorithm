T=int(input())
for tc in range(1,T+1):
  n,m=map(int,input().split())
  graph=[]
  for i in range(n):
    graph.append(list(map(int,input().split())))
  result=[]
  max_temp=0
  for i in range(n-m+1):
    for j in range(n-m+1):
      temp=0
      for k in range(j,j+m):
        for l in range(i,i+m):
          temp+=graph[k][l]
      if temp>max_temp:
        max_temp=temp
        
  print("#{} {}".format(tc,max_temp))