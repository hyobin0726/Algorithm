#요세푸스 문제
from  collections import  deque
n,k = map(int,input().split())
arr=[i for i in range(1,n+1)]
queue = deque(arr)

answer=[]
while len(queue)>0 :
    for i in range (k-1):
        a=queue.popleft()
        queue.append(a)
    b=queue.popleft()
    answer.append(str(b))
print('<'+ ', '.join(answer) + '>')