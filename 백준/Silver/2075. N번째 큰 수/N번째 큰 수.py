#n번째 큰수
import  heapq,sys
input=sys.stdin.readline
n=int(input())
num=[]
for i in range(n):
    a=list(map(int,input().split()))
    for i in range (n):
        if len(num)<n :
            heapq.heappush(num,a[i])
        else:
            if num[0] < a[i]:
                heapq.heappop(num)
                heapq.heappush(num,a[i])
print(num[0])