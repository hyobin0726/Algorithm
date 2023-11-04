n=int(input())
a=list(map(int,input().split()))
k=int(input())
b=list(map(int,input().split()))

a.sort()
total={}

for i in a:
  if i in total:
    total[i]+=1
  else:
    total[i]=1
    
for i in b:
  if i in total:
    print(total[i],end=' ')
  else:
    print(0,end=' ')