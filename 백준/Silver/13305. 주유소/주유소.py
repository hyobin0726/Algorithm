n=int(input())
distance=list(map(int,input().split()))
price=list(map(int,input().split()))

d=0
last=price[-2]
total=0

for i in range(len(price)-2,-1,-1):
  if last>=price[i]:
    last=price[i]
for i in range(price.index(last)):
  d+=distance[i]

total+=(price[0]*d+last*(sum(distance)-d))
print(total)