import sys
n=int(sys.stdin.readline())
a=[]
b=[]
for i in range(n):
  a.append(sys.stdin.readline())

for i in a:
  if i not in b:
    b.append(i)
b.sort(key=lambda x : (len(x),x))

for i in b:
  print(i,end='')