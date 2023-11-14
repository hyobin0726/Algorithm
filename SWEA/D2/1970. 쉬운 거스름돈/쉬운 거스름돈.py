T=int(input())
for tc in range (1,T+1):
    n=int(input())
    a=[50000,10000,5000,1000,500,100,50,10]
    result=[]
    for i in (a):
        result.append(n//i)
        n=(n%i)
    print("#{}".format(tc))
    print(*result)

