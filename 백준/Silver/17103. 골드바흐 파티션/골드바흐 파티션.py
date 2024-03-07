num=1000000+1
prime_list=[0]*num
#소수면 1
for i in range(1,num):
    if i == 1 :
        continue

    for j in range(2,int(i**0.5)+1):
        if i%j == 0 :
            break
    else:
        prime_list[i]=1

t = int(input())
for i in range(t):
    n=int(input())
    cnt=0
    for i in range(2,n//2+1):
        if prime_list[i]==1 and prime_list[n-i]==1:
            cnt+=1
    print(cnt)