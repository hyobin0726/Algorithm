for tc in range(1,11):
    n=int(input())
    a=[]
    for i in range(8):
        a.append(list(input()))
    temp=[]
    cnt=0
    #가로탐색
    for i in range(8):
        for j in range(8-n+1):
            temp=a[i][j:j+n]
            if temp==temp[::-1]:
                cnt+=1
    #세로탐색
    for i in range(8-n+1):
        for j in range(8):
            temp=[a[k][j]for k in range(i,i+n)]
            if temp==temp[::-1]:
                cnt+=1
    print("#{} {}".format(tc,cnt))