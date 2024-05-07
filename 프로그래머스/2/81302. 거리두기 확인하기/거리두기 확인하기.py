def solution(places):
    answer = []
    dx=[-1,1,0,0]
    dy=[0,0,-1,1]
    for k in range(5):
        cnt=0
        for i in range(5):
            for j in range(5):
                if places[k][i][j] == 'P' :
                    for l in range (4):
                        nx = i + dx[l]
                        ny = j + dy[l]
                        
                        if 0 <= nx <5 and 0<=ny<5 :
                            if places[k][nx][ny] == 'P':
                                cnt += 1
                            elif places[k][nx][ny] == 'O':
                                for m in range(4):
                                    mx = nx + dx[m]
                                    my = ny + dy[m]
                                    if mx ==i and my == j :
                                        continue
                                    if 0 <= mx < 5 and 0 <= my < 5 :
                                        if places[k][mx][my] == 'P':
                                                cnt+=1
                                      
        if cnt > 0 :
            answer.append(0)
        else :
            answer.append(1)

    return answer