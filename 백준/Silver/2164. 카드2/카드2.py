from collections import deque

n=int(input())
card=[]
for i in range(n):
    card.append(i+1)
queue=deque(card)

while len(queue)>1:
    queue.popleft()
    a=queue.popleft()
    queue.append(a)

print(queue[0])