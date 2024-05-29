def solution(n, lost, reserve):
    answer = 0
    lost.sort()
    reserve.sort()
    
    
    n_lost=[]
    n_reserve=[]
    for i in lost:
        if i not in reserve:
            n_lost.append(i)
    for i in reserve:
        if i not in lost:
            n_reserve.append(i)
    answer=n-len(n_lost)
    for i in n_lost:
        for j in n_reserve:
            if abs(i-j)==1:
                n_reserve.remove(j)
                answer+=1
    return answer