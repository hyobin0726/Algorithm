T=int(input())
def dfs(i, sum,score):
    global cnt,total
    if i ==n:
        if sum <= l:
            cnt.append(sum)
            total.append(score)
        return
    dfs(i + 1, sum, score)
    dfs(i + 1, sum + b_list[i],score+a_list[i])

for tc in range(1,T+1):
    n,l=map(int,input().split())
    a_list=[]
    b_list=[]
    for i in range (n) :
        a,b=map(int, input().split())
        a_list.append(a)
        b_list.append(b)
    cnt=[]
    total=[]
    dfs(0,0,0)
    print("#{} {}".format(tc,max(total)))
