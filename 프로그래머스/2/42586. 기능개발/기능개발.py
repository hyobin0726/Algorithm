import math
def solution(progresses, speeds):

    answer = []
    speed=[]
    
    for i in range(len(progresses)):
        speed.append(math.ceil((100-progresses[i])/speeds[i]))
    temp=speed[0]
    cnt=0
    print(speed)
    for i in range (0,len(speed)):
        if temp >= speed[i]:
            cnt+=1
        else :
            answer.append(cnt)
            cnt=1
            temp=speed[i]
    answer.append(cnt)
    return answer