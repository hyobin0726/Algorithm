from collections import deque
n,m=map(int,input().split())
arr=list(map(int,input().split()))

deq=deque(i for i in range (1,n+1))

cnt=0
for i in arr :
    while True :
        if deq[0] == i :
            deq.popleft()
            break
        else:
            if (deq.index(i)<=len(deq)//2) :
                deq.rotate(-1)
                cnt+=1
            else:
                deq.rotate(1)
                cnt+=1

print(cnt)
