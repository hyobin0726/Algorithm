import sys
input = sys.stdin.readline

n,d,k,c=map(int,input().split())
s=[]
for i in range (n):
    s.append(int(input()))

right=k
left=0

answer = 0

while left < n:
  a = set()

  for i in range(left, right):
    a.add(s[i%n])
  if c not in a:
    a.add(c)

  answer = max(answer, len(a))
  left += 1
  right += 1

print(answer)