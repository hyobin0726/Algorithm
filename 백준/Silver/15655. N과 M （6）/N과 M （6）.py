from itertools import combinations
n,m= map(int,input().split())
arr= list(map(int,input().split()))

arr. sort()

combi= list(combinations(arr, m))
for i in combi :
    print(*i)