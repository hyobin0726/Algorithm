T=int(input())
for tc in range (1,T+1):
    n=int(input())
    a=[0]*10
    result=1
    while 0 in a :
        num=str(n*result)
        for i in range(len(num)):
            a[int(num[i])] += 1
        result+=1
    print("#{} {}".format(tc,num))
