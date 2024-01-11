import sys
import heapq
input=sys.stdin.readline
n=int(input())
conference=[]

for i in range (n):
    conference.append(list(map(int,input().split())))
conference.sort()

room=[]
heapq.heappush(room,conference[0][1])#첫 수업의 종료시간

for i in range(1,n):
    if room[0]<=conference[i][0] : #현재 수업종료시간이 다음 수업시작시간보다 작거나 같다면 즉, 연강가능
        heapq.heappop(room)
        heapq.heappush(room,conference[i][1])
    else: #같은 강의실 이용불가라면
        heapq.heappush(room,conference[i][1])
print(len(room)) #총 강의실 갯수