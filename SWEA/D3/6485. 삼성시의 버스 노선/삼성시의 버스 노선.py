T=int(input())
for tc in range(1,T+1):
    n=int(input())
    result=[0]*5001
    total=[]
    for j in range(n):
        a,b=map(int,input().split())
        for i in range(a,b+1):
            result[i] +=1
    p=int(input())

    for k in range(p):
        c=int(input())
        total.append(result[c])
    print("#{}".format(tc),end=' ')
    for i in total:
        print(i,end=' ')
    print()