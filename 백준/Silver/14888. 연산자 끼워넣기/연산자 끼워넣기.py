n=int(input())
number= list(map(int,input().split()))
operator=list(map(int,input().split()))

max_n=-1e9
min_n=1e9

def dfs(cnt,total,plus,minus,multi,divi):
    global min_n,max_n
    if cnt == n :
        max_n=max(total,max_n)
        min_n=min(total,min_n)
        return

    if plus :
        dfs(cnt+1, total+number[cnt], plus-1, minus, multi, divi)
    if minus:
        dfs(cnt+1, total-number[cnt], plus, minus-1, multi, divi)
    if multi:
        dfs(cnt+1, total*number[cnt], plus, minus, multi-1, divi)
    if divi:
        if total>=0:
            dfs(cnt+1, total//number[cnt], plus, minus, multi, divi-1)
        else:
            dfs(cnt + 1, -(-total // number[cnt]), plus, minus, multi, divi - 1)
dfs(1,number[0],operator[0],operator[1],operator[2],operator[3])

print(max_n)
print(min_n)