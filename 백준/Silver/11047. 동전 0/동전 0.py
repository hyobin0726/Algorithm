n,k=map(int,input().split())
n_list=[]
sum=0
for i in range(n):
  n_list.append(int(input()))


for i in reversed(range(n)):
  sum+=k//n_list[i]
  k=k%n_list[i]
print(sum)