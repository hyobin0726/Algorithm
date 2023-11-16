T=int(input())
for tc in range(1,T+1):
    n=input()
    
    cnt=0
    for i in range (len(n)-1):
    
        if n[i] != n[i+1]:
            cnt+=1
    
    if int(n[0]) == 1:
        print("#{} {}".format(tc,cnt+1))
    else:
        print("#{} {}".format(tc, cnt))
