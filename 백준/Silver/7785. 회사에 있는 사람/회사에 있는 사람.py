import sys
n = int(sys.stdin.readline())
a = {}

for i in range(n):
  p, c =sys.stdin.readline().split()

  if c == 'enter':
    a[p] = 'enter'
  else:
    if a[p]:
      del a[p]
b=sorted(a,reverse=True)
print(*b)