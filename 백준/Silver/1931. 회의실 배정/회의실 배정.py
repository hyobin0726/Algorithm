n=int(input())
time=[]
for i in range(n):
  s, e = map(int,input().split())
  time.append([s,e])


time.sort(key=lambda x: x[0])
time.sort(key=lambda x: x[1])

last=0
count=0
for i,j in time:
  if i>=last:
    count+=1
    last=j

print(count)
