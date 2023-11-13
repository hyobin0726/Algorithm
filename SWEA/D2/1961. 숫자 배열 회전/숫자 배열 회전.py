T=int(input())
for tc in range(1,T+1):
    n=int(input())
    a=[]
    b=[[0]*n for _ in range(n)]
    c=[[0]*n for _ in range(n)]
    d=[[0]*n for _ in range(n)]
    for i in range(n):
        a.append(list(map(int,input().split())))
    
    for i in range(n):
        for j in range(n):
            b[i][j]=(str(a[n-1-j][i]))
            c[i][j]=(str(a[n-1-i][n-1-j]))
            d[i][j]=(str(a[j][n-1-i]))
    print("#{}".format(tc))
    for a1,a2,a3 in zip(b,c,d):
            a11 = ''.join(a1)
            a22 = ''.join(a2)
            a33 = ''.join(a3)
            print(a11,a22,a33)