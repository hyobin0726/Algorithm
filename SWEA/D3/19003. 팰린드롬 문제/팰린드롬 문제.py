T=int(input())
for tc in range(1,T+1):
    n,m=map(int,input().split())
    f=[]
    no=[]
    cnt=0
    result=0
    a=[]
    for i in range(n):
        a=input()
        if a==a[::-1]:
            f.append(a)
        else:
            no.append(a)
    for i in range(len(no)):
        temp=no.pop()
        if temp[::-1] in no:
            cnt+=2
    result = cnt*m
    if f:
        result+=m
    print("#{} {}".format(tc,result))
