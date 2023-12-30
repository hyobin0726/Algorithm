answer=0
def dfs(cnt, total,numbers,target):
    global answer
    if cnt== len(numbers):
        if total == target :
            answer += 1
        return
    else:
        dfs(cnt+1,total+numbers[cnt],numbers,target)
        dfs(cnt+1,total-numbers[cnt],numbers,target)
def solution(numbers, target):
    dfs(0,0,numbers,target)
    return answer