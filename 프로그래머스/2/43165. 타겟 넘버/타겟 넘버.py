answer = 0
def number(cnt, total, numbers,target):
    global answer
    if cnt == len(numbers):
        if total==target:
            answer+=1
        return 
    
    number(cnt+1,total+numbers[cnt],numbers,target)
    number(cnt+1,total-numbers[cnt],numbers,target)
def solution(numbers, target):
    number(0,0,numbers,target)
    return answer