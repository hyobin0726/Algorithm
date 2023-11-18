T=int(input())
def dfs(i, sum):
    global cnt
    if i ==n:
        if sum == k:
            cnt += 1
        return
    dfs(i + 1, sum)
    dfs(i + 1, sum + a[i])

for tc in range(1,T+1):
    n,k=map(int,input().split())
    a=[]
    a = list(map(int, input().split()))
    cnt=0
    dfs(0,0)
    print("#{} {}".format(tc,cnt))