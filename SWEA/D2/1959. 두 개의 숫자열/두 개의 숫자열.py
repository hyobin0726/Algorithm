T=int(input())
for tc in range (1,T+1):
    n,m=map(int,input().split())
    a=[]
    b=[]
    a=list(map(int,input().split()))
    b=list(map(int,input().split()))
    total=[]
    if len(a)>len(b):
        a,b=b,a
    for i in range (len(b)-len(a)+1):
        result = 0
        for j in range (len(a)):
            result+= (a[j]*b[j+i])
        total.append(result)

    print("#{} {}".format(tc,max(total)))