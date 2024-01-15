n,k = map(int,input().split())
arr=[]
move=[]
for i in range(2, n + 1):
    arr.append(i)
while len(arr)>0:
    for i in arr:
     if i%arr[0]==0:
        move.append(i)
    for i in move:
        if i in arr:
            arr.remove(i)
print(move[k-1])
