T=int(input())
for tc in range (1,T+1):
    a=[]
    a=list(map(int, input().split()))
    m=((a[1]+a[3])%60)
    h=(a[0]+a[2]+(a[1]+a[3])//60)%12
    if h == 0 :
        h=12

    print("#{} {} {}".format(tc,h,m))