T= int(input())
for i in range(T):
  n,m=map(int,input().split())
  a=list(map(int,input().split()))
  
  q=[(i,p) for i,p in enumerate(a)]
  ans=0
  
  while True:
    idx,value = q.pop(0)
    if any(value<q[i][1] for i in range(len(q))):
      q.append((idx,value))
    else:
      ans+=1
      if idx == m:
        print(ans)
        break