for tc in range(1,11):
    n=int(input())
    mag=[]
    for i in range(n):
        mag.append(list(map(int, input().split())))
    total=0
    
    for i in range(n):
        flag=0
        for j in range(n):
            if mag[j][i] == 1:
                flag =1
            elif mag[j][i]==2:
                if flag==1:
                    total+=1
                    flag=0
    print("#{} {}".format(tc,total))