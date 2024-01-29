n,k=map(int,input().split())
num=list(map(int,input().split()))
temp_sum=sum(num[:k])
total=temp_sum


for i in range(n-k):
    temp_sum = temp_sum - num[i] + num[i+k]

    if temp_sum>total:
        total=temp_sum
print(total)