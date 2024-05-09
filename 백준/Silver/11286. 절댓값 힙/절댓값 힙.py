# 절댓값 힙
import heapq,sys
input=sys.stdin.readline
n=int(input())
heap_m=[]
heap_p=[]

for i in range(n):
    x=int(input())

    if x == 0 :
        if heap_p and heap_m:
            if heap_p[0] >= heap_m[0]:
                print(-heapq.heappop(heap_m))
            else:
                print(heapq.heappop(heap_p))
        elif heap_p and not heap_m:
            print(heapq.heappop(heap_p))
        elif heap_m and not heap_p:
            print(-heapq.heappop(heap_m))
        elif not heap_m and not heap_p:
            print(0)
    elif x >0 :
        heapq.heappush(heap_p,x)
    elif x < 0 :
        heapq.heappush(heap_m,-x)

