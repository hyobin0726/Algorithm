def color(x,y,n):
    global b_cnt,w_cnt
    temp=graph[x][y]
    for i in range(x,x+n):
        for j in range(y,y+n):
            if graph[i][j]!= temp :
                color(x,y,n//2)
                color(x+n//2,y,n//2)
                color(x,y+n//2,n//2)
                color(x+n//2,y+n//2,n//2)
                return
    else:
        if temp ==0:
            w_cnt+=1
        else:
            b_cnt+=1

n=int(input())
graph=[]
for i in range (n):
    graph.append(list(map(int,input().split())))
b_cnt=0
w_cnt=0
color(0,0,n)

print(w_cnt)
print(b_cnt)