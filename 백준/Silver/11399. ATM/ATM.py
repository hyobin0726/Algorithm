n=int(input())
p=list(map(int,input().split()))
p.sort()
sum=0
a=0
for i in range(n): 
  a+= p[i]
  sum+=a
print(sum)