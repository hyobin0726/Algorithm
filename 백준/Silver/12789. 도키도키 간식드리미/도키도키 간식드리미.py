n=int(input())
arr=[]
queue=list(map(int,input().split()))
cnt=1

while queue :
    if queue[0]==cnt :
        cnt+=1
        queue.pop(0)
    else:
        arr.append(queue.pop(0))
    while arr:
        if arr[-1] == cnt:
            arr.pop()
            cnt+=1
        else:
            break
if arr :
    print("Sad")
else:
    print("Nice")