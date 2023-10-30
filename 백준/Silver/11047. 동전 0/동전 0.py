n,k=map(int,input().split())
n_list=[]
sum=0
for i in range(n):
  n_list.append(int(input()))

while k!=0:
  for i in reversed(range(n)):
    if k//n_list[i] >=1:
      sum+=k//n_list[i]
      k=k%n_list[i]
print(sum)