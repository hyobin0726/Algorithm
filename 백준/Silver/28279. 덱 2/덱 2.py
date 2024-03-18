#백준 덱 2
from collections import deque
import sys
input=sys.stdin.readline
queue=deque()
n=int(input())
for i in range (n):
    order=input().split()
    if order[0]=='1':
        queue.appendleft(order[1])
    elif order[0]=='2':
        queue.append(order[1])
    elif order[0] == '3':
        if queue :
            print(queue.popleft())
        else:
            print(-1)
    elif order[0] == '4':
        if queue :
            print(queue.pop())
        else:
            print(-1)
    elif order[0] == '5':
        print(len(queue))
    elif order[0] == '6':
        if queue :
            print(0)
        else:
            print(1)
    elif order[0] == '7':
        if queue :
            print(queue[0])
        else:
            print(-1)
    elif order[0]=='8':
        if queue :
            print(queue[-1])
        else:
            print(-1)