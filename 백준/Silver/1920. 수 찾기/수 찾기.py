n=int(input())
a=list(map(int,input().split()))
m=int(input())
b=list(map(int,input().split()))

a.sort()

for num in b:
  f,e = 0, n-1
  exist=False
  
  while f<=e:
    mid=(f+e)//2
    if num == a[mid]:
      exist=True
      print(1)
      break
    elif num > a[mid]:
      f=mid+1
    else:
      e=mid-1
  if not exist:
    print(0)