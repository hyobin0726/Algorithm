
T=int(input())
for tc in range(1,T+1):
    n=int(input())
    a=[]
    for i in range(n):
        temp=[]
        for j in range(i+1):
            if j==0 or j == i:
                temp.append(1)
            else:
                temp.append(a[i-1][j-1]+a[i-1][j])
        a.append(temp)
    print("#{}".format(tc))
    for i in range(n):
        print(*a[i])