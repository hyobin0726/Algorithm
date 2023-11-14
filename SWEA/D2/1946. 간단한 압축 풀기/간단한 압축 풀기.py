T=int(input())
for tc in range (1,T+1):
    n=int(input())
    result=[]
    for i in range(n):
        a,b = map(str,input().split())
        result+=(a*int(b))
    result ="".join(result)
    print("#{}".format(tc))
    for i in range(len(result)//10+1):
        print(result[i*10:i*10+10])
    #a=list(map(int,input().split()))

    #print("#{}".format(tc),end=' ')
