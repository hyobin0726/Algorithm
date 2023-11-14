T=int(input())
for tc in range (1,T+1):
    n=int(input())
    a=[]
    a=list(map(int,input().split()))
    a.sort()
    print("#{}".format(tc),end=' ')
    for i in range (n):
        print(a[i], end=' ')
    print()
