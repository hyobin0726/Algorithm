T=int(input())
def dfs(i, sum):
    global cnt
    if i ==n:
        if sum >= b:
            cnt.append(sum)
        return
    dfs(i + 1, sum)
    dfs(i + 1, sum + a[i])

for tc in range(1,T+1):
    n,b=map(int,input().split())
    a=[]
    a = list(map(int, input().split()))
    cnt=[]
    dfs(0,0)
    print("#{} {}".format(tc,min(cnt)-b))