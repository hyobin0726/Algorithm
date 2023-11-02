n, m =map(int,input().split())
a=set()
cnt=0

for i in range(n):
  a.add(input())

for i in range(m):
  b=input()
  if b in a:
    cnt+=1
print(cnt)