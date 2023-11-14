T=int(input())
for tc in range (1,T+1):
    a=[]
    a=list(map(int, input().split()))
    result=0
    a_max=max(a)
    a_min=min(a)
    for i in (a):
        if i != a_max and i != a_min:
            result+= i

    print("#{} {}".format(tc,round(result/8)))
