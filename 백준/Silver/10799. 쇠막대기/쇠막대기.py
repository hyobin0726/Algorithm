#쇠막대기
from  collections import  deque
stick=input()
queue=deque(stick)
answer=0
temp=[]
num=0
for i in range(len(stick)):
    a=queue.popleft()
    if a == '(':
        temp.append('(')
    else:
        if stick[i-1] == '(':
            temp.pop()
            answer+=len(temp)
        else:
            temp.pop()
            answer+=1
print(answer)
