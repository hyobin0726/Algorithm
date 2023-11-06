for test_case in range(1,11):
  n=int(input())
  graph=list(map(int,input().split()))
  cnt=0
  for i in range(2,n-2):
    d1=graph[i]-graph[i-2]
    d2=graph[i]-graph[i-1]
    d3=graph[i]-graph[i+1]
    d4=graph[i]-graph[i+2]
    if d1>0and d2>0 and d3>0 and d4>0:
      cnt+=min(d1,d2,d3,d4)

  print("#{} {}".format(test_case,cnt))
