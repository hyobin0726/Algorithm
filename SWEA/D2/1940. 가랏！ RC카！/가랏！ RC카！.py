T=int(input())
for tc in range (1,T+1):
    n=int(input())
    result=0
    total=[]
    a=[]
    for i in range(n):
        a = list(map(int,input().split()))

        if a[0] == 1 :
            result +=a[1]
        elif a[0] == 0 :
            result = result
        else:
            result -= a[1]
        if result<0:
            result=0
        total.append(result)

    print("#{} {}".format(tc,sum(total)))