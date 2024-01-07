import heapq
n = int(input())
card = []
for i in range(n):
    card.append(int(input()))
heapq.heapify(card)  # 리스트를 최소 힙으로 변환

total = 0
while len(card) > 1:
    min1 = heapq.heappop(card)
    min2 = heapq.heappop(card)
    answer = min1 + min2
    total += answer
    heapq.heappush(card, answer)  

print(total)