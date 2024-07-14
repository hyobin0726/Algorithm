n, k = map(int, input().split())
sum = 0

# 최소 공의 합 계산
for i in range(1, k+1):
    sum += i

# 공이 부족한 경우
if n < sum:
    print(-1)
else:
    remaining = n - sum  

    # k가 2인 경우
    if k == 2:
        if remaining % 2 == 0:
            print(k - 1)
        else:
            print(k)
    
    # k가 홀수인 경우
    elif k % 2 == 1:
        if remaining % k == 0:
            print(k - 1)
        else:
            print(k)
    
    # k가 짝수인 경우
    else:
        if remaining % k == 0:
            print(k - 1)
        else:
            print(k)
