from collections import deque
T = int(input())
for tc in range(1,T+1):
    n,m=map(int,input().split())
    a=[]
    b=[]
    w= deque([]) #대기
    p=[0]*n #주차장
    total=0

    for i in range(n):
        a.append(int(input()))
    for i in range(m):
        b.append(int(input()))

    for i in range(m*2):
       c=int(input())
       if c>0: #들어옴,돈
           for j in range(n):
               if p[j] ==0:
                   p[j]=c
                   total+=a[j]*b[c-1]
                   break
           else :
             w.append(c)
       else: #나감
           c = abs(c)
           for j in range(n):
               if p[j] == c:
                   if len(w)>0: #대기 차량이 있다면 대기들어옴,돈
                       c=w.popleft()
                       p[j] =c
                       total += a[j]*b[c-1]
                       break
                   else: #대기 없다면 0으로 복귀
                       p[j]=0
                       break
    print("#{} {}".format(tc,total))