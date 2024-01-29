n,s=map(int,input().split())
num=list(map(int,input().split()))

left=0
right=0
temp_sum=0

min_length=100001

while True:
    if temp_sum >= s :
        min_length=min(min_length,right-left)
        temp_sum -= num[left]
        left+=1

    elif right == n:
        break
    else:
        temp_sum+=num[right]
        right+=1
if min_length == 100001:
    print(0)
else:
    print(min_length)