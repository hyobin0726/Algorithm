import heapq
def solution(scoville, K):
    answer = 0
    heapq.heapify(scoville)
    
    while True :
        a=heapq.heappop(scoville)
        if a >= K :
            return answer
        elif len(scoville)<1 :
            return -1
        else:
            b=heapq.heappop(scoville)
            heapq.heappush(scoville, a+2*b)
            answer+=1
    return answer