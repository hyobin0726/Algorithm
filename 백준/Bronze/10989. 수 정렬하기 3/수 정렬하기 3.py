import sys
n=int(sys.stdin.readline())
a=[0]*(10**4)
for i in range(n):
  b=int(sys.stdin.readline())
  a[b-1]+=1

for i in range(10000):
  if a[i]!=0:
    for j in range (a[i]):
      print(i+1)
  