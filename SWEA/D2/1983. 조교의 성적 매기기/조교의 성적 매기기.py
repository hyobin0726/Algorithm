T=int(input())
for tc in range (1,T+1):
    grades = ['A+', 'A0', 'A-', 'B+', 'B0', 'B-', 'C+', 'C0', 'C-', 'D0']
    n,k= map(int,input().split())
    a=[]
    b=[]
    c=0
    k_score=0
    for i in range (n):
        a.append(list(map(int, input().split())))
        c=(a[i][0]*0.35+a[i][1]*0.45+a[i][2]*0.2)
        b.append(c)
    k_score=b[k-1]
    b.sort(reverse=True)
    div = n//10
    total=b.index(k_score)//div

    print("#{} {}".format(tc,grades[total]))

