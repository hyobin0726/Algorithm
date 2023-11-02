n=int(input())
a=list(map(int,input().split()))
k=int(input())
b=list(map(int,input().split()))

a.sort()
total=[]
for num in b:
  f,e =0,n-1
  exist=False
  while f<=e:
    mid=(f+e)//2
    if num == a[mid]:
      exist=True
      total.append(1)
      break
      
    elif num < a[mid]:
      e=mid-1
    else:
      f=mid+1
  if not exist:
    total.append(0)
print(*total)