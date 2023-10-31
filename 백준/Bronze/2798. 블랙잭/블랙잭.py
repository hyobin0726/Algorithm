n,m=map(int,input().split())
b=[]
a=(list(map(int,input().split())))
  
for i in range(0,n-2):
  for j in range(i+1,n-1):
    for k in range(j+1,n):
      b.append(a[i]+a[j]+a[k])
c=[]
for i in range(len(b)):
  if m >= b[i]:
    c.append(b[i])
print(max(c))
