for tc in range (1,11):
    n=int(input())
    graph=[]
    result=[]
    for i in range (100):
        graph.append(list(map(int, input().split())))
    for i in range (100):
        total=0
        for j in range(100):
            total+=graph[i][j]
            result.append(total)
    for i in range (100):
        total=0
        for j in range(100):
            total+=graph[j][i]
            result.append(total)
    print("#{} {}".format(tc,max(result)))
