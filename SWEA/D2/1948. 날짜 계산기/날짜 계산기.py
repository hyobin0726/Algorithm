T=int(input())
for tc in range (1,T+1):
    
    d=[0,31,28,31,30,31,30,31,31,30,31,30,31]
    a=[]
    a=list(map(int,input().split()))
    result=0
    if a[0]==a[2]:
        result=(a[3]-a[1]+1)
    else:
        for i in range (a[2]-1,a[0],-1):
            result += d[i]
        result = (result +a[3]+ (d[a[0]]-a[1]) +1)
    print("#{} {}".format(tc,result))