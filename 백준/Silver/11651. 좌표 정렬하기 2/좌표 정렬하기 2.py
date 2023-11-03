import sys
n=int(sys.stdin.readline())
a=[]
for i in range(n):
  x,y=map(int,sys.stdin.readline().split())
  a.append((x,y))

  

a.sort(key=lambda x: (x[1], x[0]))

for i in range(n):
  print(*a[i])