def color(x,y,n):
    global one_cnt,zero_cnt,minus_cnt
    temp=graph[x][y]
    for i in range(x,x+n):
        for j in range(y,y+n):
            if graph[i][j]!= temp :
                color(x,y,n//3)
                color(x, y + n // 3, n // 3)
                color(x, y + (2 * n) // 3, n // 3)
                color(x+n//3,y,n//3)
                color(x + n // 3, y + n // 3, n // 3)
                color(x + n // 3, y + (2*n) // 3, n // 3)
                color(x + (2*n) // 3, y, n // 3)
                color(x + (2 * n) // 3, y+n//3, n // 3)
                color(x + (2*n) // 3, y + (2*n) // 3, n // 3)
                return
    else:
        if temp ==0:
            zero_cnt+=1
        elif temp ==1:
            one_cnt+=1
        else:
            minus_cnt+=1


n=int(input())
graph=[]
for i in range (n):
    graph.append(list(map(int,input().split())))
zero_cnt=0
one_cnt=0
minus_cnt=0
color(0,0,n)

print(minus_cnt)
print(zero_cnt)
print(one_cnt)