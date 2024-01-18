import math
from collections import deque


#소수판별 코드
def isprime(x):
    for i in range(2,int(math.sqrt(x))+1):
        if x % i ==0:
            return False
    return  True

def bfs(a,b):
    q=deque()
    q.append((a,0))

    while q:
        password, count  =q.popleft()
        if password == b :
            print(count)

            return

        for i in range(4): #4자리수
            for j in range(10): #0부터 9까지
                new = list(str(password))
                new[i]=str(j)
                new = int(''.join(new))
                if 1000<=new and not visited[new] and isprime(new):
                    visited[new]=True
                    q.append((new,count+1))

#실행코드
t=int(input())
for i in range(t):
    a,b=map(int,input().split())
    visited = [0]*10000
    visited[a]=True
    bfs(a,b)